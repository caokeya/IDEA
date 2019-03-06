package src.com.Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。
现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一组 K 名工人时，我们必须按照下述规则向他们支付工资：
    对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
    工资组中的每名工人至少应当得到他们的最低期望工资。
返回组成一个满足上述条件的工资组至少需要多少钱。
示例 1：
输入： quality = [10,20,5], wage = [70,50,30], K = 2
输出： 105.00000
解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
示例 2：
输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
输出： 30.66667
解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
 */
public class _857_Minimum_Cost_to_Hire_K_Workers_雇佣K名工人的最低成本_难 {
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
            double[][] works = new double[wage.length][2];
            for (int i = 0; i < quality.length; i++) {
                works[i][0] = (double) wage[i] / quality[i];
                works[i][1] = (double) quality[i];
            }
            Arrays.sort(works, new Comparator<double[]>() {
                public int compare(double[] a, double[] b) {
                    return Double.compare(a[0], b[0]);
                }
            });
            PriorityQueue<Double> pq = new PriorityQueue<>();
            double result = Double.MAX_VALUE;
            double cur = 0;
            for (double work[] : works) {
                cur += work[1];
                pq.offer(-work[1]);
                if (pq.size() > K) {
                    double tmp = pq.poll();
                    cur += tmp;
                    if (-tmp == work[1]) {
                        continue;
                    }
                }
                if (pq.size() == K) {
                    result = Math.min(result, cur * work[0]);
                }
            }
            return result;
        }
    }

    class Solution2 {
        class Worker {
            int quality;
            double ratio;

            Worker(double ratio, int quality) {
                this.quality = quality;
                this.ratio = ratio;
            }
        }

        public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
            int len = wage.length;
            // 建立一个arr存worker信息： ratio和对应的quality
            Worker[] w = new Worker[len];
            for (int i = 0; i < len; i++) {
                w[i] = new Worker((double) wage[i] / quality[i], quality[i]);
            }
            // 按照worker ratio 从小到大排序
            Arrays.sort(w, (a, b) -> Double.compare(a.ratio, b.ratio));

            // 建立一个pq（min heap，poll最小的） 放入每个worker的 - quality, 这样poll出来的就是最大的quality
            // pq维持当前quality最小的四个worker, 这样可以保证最后付的钱是最少的
            double res = Double.MAX_VALUE;
            int qSum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for (Worker q : w) {
                qSum += q.quality; // new quality
                pq.offer(q.quality); // offer negative val since we are polling the min
                if (pq.size() > K) { // getting rid of highest quality
                    qSum -= pq.poll();
                }
                if (pq.size() == K) {
                    res = Math.min(res, qSum * q.ratio); // quality sum * new ratio
                }
            }
            return res;
        }
    }
}

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
            //wage[i] : wage[j] == quality[i] : quality[j]
            //wage[i] : quality[i] == wage[j] : quality[j]  == ratio
            double[][] workers = new double[quality.length][2];
            for (int i = 0; i < quality.length; i++) {
                workers[i] = new double[]{(double) wage[i] / quality[i], quality[i]};
            }
            Arrays.sort(workers, new Comparator<double[]>() {//排序 工资/质量
                public int compare(double[] a, double[] b) {
                    return Double.compare(a[0], b[0]);
                }
            });
            PriorityQueue<Double> pq = new PriorityQueue<>();
            double res = Integer.MAX_VALUE;
            int qualitySum = 0;
            for (double[] worker : workers) {
                double ratio = worker[0];
                qualitySum += worker[1];
                pq.offer(-worker[1]);
                if (pq.size() > K)
                    qualitySum += pq.poll(); // now pq.poll()给出来的是负的，所以加上负的，等于减去正的，也就是把大quality的先去除。
                if (pq.size() == K)
                    res = Math.min(res, qualitySum * ratio); // 其实这道题目也就是不知道ratio小的对应的quality是否大，所以要每一个都检查
            }
            return res;
        }
    }
}

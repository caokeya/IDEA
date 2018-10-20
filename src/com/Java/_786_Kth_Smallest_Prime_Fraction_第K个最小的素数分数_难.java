package src.com.Java;

/*
一个已排序好的表 A，其包含 1 和其他一些素数.  当列表中的每一个 p<q 时，我们可以构造一个分数 p/q 。
那么第 k 个最小的分数是多少呢?  以整数数组的形式返回你的答案, 这里 answer[0] = p 且 answer[1] = q.
示例:
输入: A = [1, 2, 3, 5], K = 3
输出: [2, 5]
解释:
已构造好的分数,排序后如下所示:
1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
很明显第三个最小的分数是 2/5.
输入: A = [1, 7], K = 1
输出: [1, 7]
 */
public class _786_Kth_Smallest_Prime_Fraction_第K个最小的素数分数_难 {
    class Solution {
        public int[] kthSmallestPrimeFraction(int[] A, int K) {
            double l = 0, r = 1;
            while (true) {
                double m = (l + r) / 2;
                int[] res = count(A, m);
                if (res[0] == K) {
                    return new int[] { res[1], res[2] };
                } else if (res[0] > K) {
                    r = m;
                } else {
                    l = m;
                }
            }
        }

        private int[] count(int[] A, double num) {
            int cnt = 0;
            int p = 0, q = 1;
            for (int l = -1, r = 1; r < A.length; r++) {
                while (A[l + 1] * 1.0 / A[r] <= num)
                    l++;
                cnt += l + 1;
                if (l >= 0 && p * A[r] < q * A[l]) {
                    p = A[l];
                    q = A[r];
                }
            }
            return new int[] { cnt, p, q };
        }
    }
    
    class Solution2 {

        // for [1, 2, 3 ,5]

        // vitual table
        //      5,   3,   2, 1
        // 1  0.2, 0.3, 0.5, 1
        // 2  0.4, 0.6,   1, 2
        // 3  0.6,   1, 1.5, 3
        // 5    1, 1.6, 2.5, 5

        public int[] kthSmallestPrimeFraction(int[] A, int K) {
            double lowerBound = 0, upperBound = 1;

            while (true) {
                double tempRet = lowerBound + (upperBound - lowerBound) / 2.0;

                int count = 0;
                int[] ret = new int[2];
                ret[1] = 1;
                for (int i = 0, j = 0; i < A.length && j < A.length; i++) {
                    while (j < A.length && (A[i] * 1.0) / (A[j] * 1.0) > tempRet) {
                        j++;
                    }

                    // 2 / 3 = 0.6
                    // 3 / 5 = 0.6
                    // all smaller than 0.75
                    // which one is answer
                    // the bigger one is the answer
                    // so we only update our ret when
                    // temp[0] / temp[1] < A[i] / A[j]
                    if (j < A.length && ret[0] * A[j] < ret[1] * A[i]) {
                        ret[0] = A[i];
                        ret[1] = A[j];
                    }

                    count += A.length - j;
                }

                // if the upperBound and lowerBound is double
                // lowerBound will always smaller than upperBound
                // case 1: we set a threshold, lowerBound + threshold < upperBound
                // case 2: count == k
                if (count > K) {
                    upperBound = tempRet;
                } else if (count < K) {
                    lowerBound = tempRet;
                } else {
                    return ret;
                }
            }

        }
    }
}

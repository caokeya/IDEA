package src.com.Java;

/*
我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
示例:
输入: 
A = [9,1,2,3,9]
K = 3
输出: 20
解释: 
A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
我们也可以把 A 分成[9, 1], [2], [3, 9].
这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 */
public class _813_Largest_Sum_of_Averages_最大平均值和的分组 {
    class Solution {
        public double largestSumOfAverages(int[] A, int K) {
            int N = A.length;
            double[] sum = new double[N + 1];
            for (int i = 0; i < N; ++i)
                sum[i + 1] = sum[i] + A[i];//记录各个位置的总和

            double[] dp = new double[N];
            for (int i = 0; i < N; ++i)
                dp[i] = (sum[N] - sum[i]) / (N - i);//求出末尾得到各位置的平均值

            for (int k = 0; k < K - 1; ++k)
                for (int i = 0; i < N; ++i)
                    for (int j = i + 1; j < N; ++j) {
                        dp[i] = Math.max(dp[i], (sum[j] - sum[i]) / (j - i) + dp[j]);

                    }

            return dp[0];
        }
    }
}

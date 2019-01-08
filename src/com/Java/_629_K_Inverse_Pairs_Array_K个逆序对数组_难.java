package src.com.Java;

/*
给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
由于答案可能很大，只需要返回 答案 mod 10^9 + 7 的值。
示例 1:
输入: n = 3, k = 0
输出: 1
解释: 
只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
示例 2:
输入: n = 3, k = 1
输出: 2
解释: 
数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
 */
public class _629_K_Inverse_Pairs_Array_K个逆序对数组_难 {
    /*
    if we put n as the last number then all the k inverse pair should come from the first n-1 numbers
    if we put n as the second last number then there's 1 inverse pair involves n so the rest k-1 comes from the first n-1 numbers
    ...
    if we put n as the first number then there's n-1 inverse pairs involve n so the rest k-(n-1) comes from the first n-1 numbers
    dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]

    dp[n][k] =               dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]
    dp[n][k+1] =dp[n-1][k+1]+dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]
    so by deducting the first line from the second line, we have
    dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]
    dp[n][k] = dp[n][k-1]+dp[n-1][k]-dp[n-1][k-n]
     */
    class Solution {
        public int kInversePairs(int n, int k) {
            int mod = 1000000007;
            if (k > n * (n - 1) / 2 || k < 0) return 0;
            if (k == 0 || k == n * (n - 1) / 2) return 1;
            long[][] dp = new long[n + 1][k + 1];
            dp[2][0] = 1;
            dp[2][1] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    if (j >= i)
                        dp[i][j] -= dp[i - 1][j - i];
                    dp[i][j] = (dp[i][j] + mod) % mod;
                }
            }
            return (int) dp[n][k];
        }
    }
}

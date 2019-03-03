package com.Java;

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
     * dp[n][k] =dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]
     * dp[n][k+1] =dp[n-1][k+1]+dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]
     * so by deducting the first line from the second line, we have
     * dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]
     */
    class Solution {
        public int kInversePairs(int n, int k) {
            int[][] dp = new int[n + 1][k + 1];
            int M = 1000000007;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= k && j <= i * (i - 1) / 2; j++) {
                    if (i == 1 && j == 0) {
                        dp[i][j] = 1;
                        break;
                    } else if (j == 0)
                        dp[i][j] = 1;
                    else {
                        int val = (dp[i][j - 1] + dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                        dp[i][j] = val % M;
                    }
                }
            }
            return dp[n][k];
        }
    }
}

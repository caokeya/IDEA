package com.Java;

/*
给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。
但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
示例 1：
输入: m = 2, n = 2, N = 2, i = 0, j = 0
输出: 6
解释:
示例 2：
输入: m = 1, n = 3, N = 3, i = 0, j = 1
输出: 12
解释:
 */
public class _576_Out_of_Boundary_Paths_出界的路径数 {
    class Solution {
        public int findPaths(int m, int n, int N, int i, int j) {
            if (N <= 0)
                return 0;
            Integer[][][] memo = new Integer[N + 1][m][n];
            return helper(m, n, N, i, j, memo);
        }

        public int helper(int m, int n, int N, int i, int j, Integer[][][] memo) {
            int x = 1000000007;
            if (N < 0)
                return 0;
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return 1;
            }
            if (memo[N][i][j] != null)
                return memo[N][i][j];
            memo[N][i][j] = ((helper(m, n, N - 1, i - 1, j, memo) + 
                              helper(m, n, N - 1, i + 1, j, memo)) % x + 
                             (helper(m, n, N - 1, i, j - 1, memo) +
                              helper(m, n, N - 1, i, j + 1, memo)) % x) % x;
            return memo[N][i][j];
        }
    }
}

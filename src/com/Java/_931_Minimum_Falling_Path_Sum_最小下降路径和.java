package com.Java;

/*
给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
示例：
输入：[[1,2,3],[4,5,6],[7,8,9]]
输出：12
解释：
可能的下降路径有：
    [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
    [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
    [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
和最小的下降路径是 [1,4,7]，所以答案是 12。
 */
public class _931_Minimum_Falling_Path_Sum_最小下降路径和 {
    class Solution {
        public int minFallingPathSum(int[][] A) {
            int rows = A.length;
            int cols = A[0].length;
            // DP matrix has 2 extra columns
            int[][] dp = new int[rows][cols + 2];
            // Fill the first row of DP matrix
            for (int i = 1; i <= cols; i++) {
                dp[0][i] = A[0][i - 1];
            }
            // Fill Integer.MAX_VALUE into first and last column of DP matrix
            for (int i = 0; i < rows; i++) {
                dp[i][0] = Integer.MAX_VALUE;
                dp[i][cols + 1] = Integer.MAX_VALUE;
            }
            // Building the DP matrix
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    // Find the minimum neighbor from previous row in DP matrix
                    int minNeighbor = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    minNeighbor = Math.min(minNeighbor, dp[i - 1][j + 1]);
                    dp[i][j] = A[i][j - 1] + minNeighbor;
                }
            }
            // The minimum path sum is minimum of the last row in DP matrix
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= cols; i++) {
                min = Math.min(min, dp[rows - 1][i]);
            }
            return min;
        }
    }
}

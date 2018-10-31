package src.com.Java;

/*
给定一个整数a的平方数组，我们想要通过a的下降路径的最小和。
下降路径从第一行的任何元素开始，并从每一行中选择一个元素。下一行的选择必须在与前一行的列最多有一个不同的列中。
Example 1:
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation: 
The possible falling paths are:
    [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
    [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
    [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.
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

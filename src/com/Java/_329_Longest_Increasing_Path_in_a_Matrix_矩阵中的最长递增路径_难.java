package src.com.Java;

/*
给定一个整数矩阵，找出最长递增路径的长度。
对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
示例 :
输入: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
输出: 4 
解释: 最长递增路径为 [1, 2, 6, 9]。
 */
public class _329_Longest_Increasing_Path_in_a_Matrix_矩阵中的最长递增路径_难 {
    public class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int[][] cache = new int[matrix.length][matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int length = findSmallAround(i, j, matrix, cache, Integer.MAX_VALUE);
                    max = Math.max(length, max);
                }
            }
            return max;
        }

        private int findSmallAround(int i, int j, int[][] matrix, int[][] cache, int pre) {
            // if out of bond OR current cell value larger than previous cell value.
            if (i < 0 || i >= matrix.length ||
                j < 0 || j >= matrix[0].length ||
                matrix[i][j] >= pre) {
                return 0;
            }
            // if calculated before, no need to do it again
            if (cache[i][j] > 0) {
                return cache[i][j];
            } else {
                int cur = matrix[i][j];
                int tempMax = 0;
                tempMax = Math.max(findSmallAround(i - 1, j, matrix, cache, cur), tempMax);
                tempMax = Math.max(findSmallAround(i + 1, j, matrix, cache, cur), tempMax);
                tempMax = Math.max(findSmallAround(i, j - 1, matrix, cache, cur), tempMax);
                tempMax = Math.max(findSmallAround(i, j + 1, matrix, cache, cur), tempMax);
                cache[i][j] = ++tempMax;
                return tempMax;
            }
        }
    }
}

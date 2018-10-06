package src.com.Java;

/*
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
示例:
给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
 */
public class _304_Range_Sum_Query_2D_Immutable_二维区域和检索矩阵不可变 {
    class NumMatrix {
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return;
            int m = matrix.length;
            int n = matrix[0].length;
            dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];

        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
     * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
}

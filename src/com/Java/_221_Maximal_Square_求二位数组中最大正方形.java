package src.src.com.Java;

/*
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
示例:
输入:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4
*/
public class _221_Maximal_Square_求二位数组中最大正方形 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0) return 0;
            int m = matrix.length, n = matrix[0].length;
            int[][] board = new int[m + 1][n + 1];
            int result = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        board[i][j] = Math.min(Math.min(board[i - 1][j - 1], board[i - 1][j]), board[i][j - 1]) + 1;
                        result = Math.max(result, board[i][j]);
                    }
                }
            }
            return result * result;
        }
    }
}

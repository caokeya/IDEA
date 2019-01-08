package src.com.Java;

/*
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。
示例 1:
输入:
0 0 0
0 1 0
0 0 0
输出:
0 0 0
0 1 0
0 0 0
示例 2:
输入:
0 0 0
0 1 0
1 1 1
输出:
0 0 0
0 1 0
1 2 1
 */
public class _542_01_Matrix_01矩阵 {
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int row = matrix.length;
            if (row == 0) {
                return matrix;
            }
            int col = matrix[0].length;
            int[][] dist = new int[row][col];

            // top left to bottom right，first pass
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = Integer.MAX_VALUE - 1;
                        // top
                        if (i > 0) {
                            dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                        }
                        // left
                        if (j > 0) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                        }
                    }
                }
            }
            // bottom right to top left,second pass
            for (int i = row - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    if (i < row - 1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j < col - 1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
            return dist;
        }
    }

    public class SolutionDFS {
        public int[][] updateMatrix(int[][] matrix) {
            if (matrix.length == 0)
                return matrix;

            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length; j++)
                    if (matrix[i][j] == 1 && !hasNeiberZero(i, j, matrix))
                        matrix[i][j] = matrix.length + matrix[0].length + 1;

            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length; j++)
                    if (matrix[i][j] == 1)
                        dfs(matrix, i, j, -1);

            return matrix;
        }

        private void dfs(int[][] matrix, int x, int y, int val) {
            if (x < 0 || y < 0 || y >= matrix[0].length || x >= matrix.length || matrix[x][y] <= val)
                return;

            if (val > 0)
                matrix[x][y] = val;

            dfs(matrix, x + 1, y, matrix[x][y] + 1);
            dfs(matrix, x - 1, y, matrix[x][y] + 1);
            dfs(matrix, x, y + 1, matrix[x][y] + 1);
            dfs(matrix, x, y - 1, matrix[x][y] + 1);

        }

        private boolean hasNeiberZero(int x, int y, int[][] matrix) {
            if (x > 0 && matrix[x - 1][y] == 0)
                return true;
            if (x < matrix.length - 1 && matrix[x + 1][y] == 0)
                return true;
            if (y > 0 && matrix[x][y - 1] == 0)
                return true;
            if (y < matrix[0].length - 1 && matrix[x][y + 1] == 0)
                return true;

            return false;
        }
    }
}

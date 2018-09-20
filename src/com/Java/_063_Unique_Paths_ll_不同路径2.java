package src.com.Java;

public class _063_Unique_Paths_ll_不同路径2 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int rows = obstacleGrid.length;
            int cols = obstacleGrid[0].length;

            int[][] paths = new int[rows][cols];

            // initial the first row
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[0][col] != 1) {
                    paths[0][col] = 1;
                } else {
                    break;
                }
            }
            // initial the first column
            for (int row = 0; row < rows; row++) {
                if (obstacleGrid[row][0] != 1) {
                    paths[row][0] = 1;
                } else {
                    break;
                }
            }

            for (int row = 1; row < rows; row++) {
                for (int col = 1; col < cols; col++) {
                    if (obstacleGrid[row][col] == 1) {
                        paths[row][col] = 0;
                    } else {
                        paths[row][col] = paths[row - 1][col] + paths[row][col - 1];
                    }
                }
            }
            return paths[rows - 1][cols - 1];
        }
    }
}

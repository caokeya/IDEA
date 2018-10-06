package src.com.Java;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
示例 1:
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
 */
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

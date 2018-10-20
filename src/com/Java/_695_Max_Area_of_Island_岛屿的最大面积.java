package src.com.Java;

/*
给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
示例 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。

 */
public class _695_Max_Area_of_Island_岛屿的最大面积 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        maxArea = Math.max(maxArea, findIslandSize(grid, i, j));
                    }
                }
            }

            return maxArea;
        }

        public int findIslandSize(int[][] grid, int i, int j) {
            if (i == grid.length || i < 0 || j < 0 || j == grid[i].length || grid[i][j] == 0) {
                return 0;
            }

            grid[i][j] = 0;
            return 1 + findIslandSize(grid, i + 1, j) + 
                       findIslandSize(grid, i - 1, j) + 
                       findIslandSize(grid, i, j + 1) + 
                       findIslandSize(grid, i, j - 1) ;
        }
    }
}

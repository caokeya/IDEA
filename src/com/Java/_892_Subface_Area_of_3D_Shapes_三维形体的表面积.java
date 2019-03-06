package src.com.Java;

/*
在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
返回结果形体的总表面积。
示例 1：
输入：[[2]]
输出：10
示例 2：
输入：[[1,2],[3,4]]
输出：34
示例 3：
输入：[[1,0],[0,2]]
输出：16
示例 4：
输入：[[1,1,1],[1,0,1],[1,1,1]]
输出：32
示例 5：
输入：[[2,2,2],[2,1,2],[2,2,2]]
输出：46
 */
public class _892_Subface_Area_of_3D_Shapes_三维形体的表面积 {
    class Solution {
        public int surfaceArea(int[][] grid) {
            int res = 0, n = grid.length;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] > 0)
                        res += grid[i][j] * 4 + 2;
                    if (i > 0)
                        res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    if (j > 0)
                        res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
            return res;
        }
    }
}

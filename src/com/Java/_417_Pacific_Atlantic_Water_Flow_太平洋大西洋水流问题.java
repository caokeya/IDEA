package com.Java;

import java.util.LinkedList;
import java.util.List;

/*
给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
提示：
    输出坐标的顺序不重要
    m 和 n 都小于150
示例：
给定下面的 5x5 矩阵:
  太平洋 ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * 大西洋
返回:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
public class _417_Pacific_Atlantic_Water_Flow_太平洋大西洋水流问题 {
    class Solution {
        public List<int[]> pacificAtlantic(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return new LinkedList<>();

            int n = matrix.length, m = matrix[0].length;
            boolean[][] pacific = new boolean[n][m];
            boolean[][] alantic = new boolean[n][m];

            for (int j = 0; j < m; ++j) {
                if (!pacific[0][j])
                    dfs(0, j, matrix, pacific);
                if (!alantic[n - 1][j])
                    dfs(n - 1, j, matrix, alantic);
            }
            for (int i = 0; i < n; ++i) {
                if (!pacific[i][0])
                    dfs(i, 0, matrix, pacific);
                if (!alantic[i][m - 1])
                    dfs(i, m - 1, matrix, alantic);
            }

            List<int[]> ans = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (pacific[i][j] && alantic[i][j])
                        ans.add(new int[] { i, j });
                }
            }
            return ans;
        }

        private void dfs(int i, int j, int[][] matrix, boolean[][] ocean) {
            if (ocean[i][j])
                return;
            ocean[i][j] = true;
            if (i > 0 && matrix[i][j] <= matrix[i - 1][j])
                dfs(i - 1, j, matrix, ocean);
            if (i < matrix.length - 1 && matrix[i][j] <= matrix[i + 1][j])
                dfs(i + 1, j, matrix, ocean);
            if (j > 0 && matrix[i][j] <= matrix[i][j - 1])
                dfs(i, j - 1, matrix, ocean);
            if (j < matrix[0].length - 1 && matrix[i][j] <= matrix[i][j + 1])
                dfs(i, j + 1, matrix, ocean);
            return;
        }
    }
}

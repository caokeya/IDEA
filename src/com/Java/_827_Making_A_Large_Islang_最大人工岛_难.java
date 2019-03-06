package src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
示例 1:
输入: [[1, 0], [0, 1]]
输出: 3
解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
示例 2:
输入: [[1, 1], [1, 0]]
输出: 4
解释: 将一格0变成1，岛屿的面积扩大为 4。
示例 3:
输入: [[1, 1], [1, 1]]
输出: 4
解释: 没有0可以让我们变成1，面积依然为 4。
 */
public class _827_Making_A_Large_Islang_最大人工岛_难 {
    class Solution {
        private final int[][] MOVES = new int[][] {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        public int largestIsland(int[][] grid) {
            int idx = 2;
            int m = grid.length;
            int n = grid[0].length;
            int[] area = new int[n * n + 2];

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        area[idx] = dfs(grid, i, j, idx);
                        ans = Math.max(ans, area[idx++]);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        int count = 1;
                        Set<Integer> set = new HashSet<>();
                        for (int[] move : MOVES) {
                            int r = i + move[0];
                            int c = j + move[1];
                            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || set.contains(grid[r][c])) {
                                continue;
                            }
                            set.add(grid[r][c]);
                            count += area[grid[r][c]];
                        }
                        ans = Math.max(count, ans);
                    }
                }
            }
            return ans;
        }

        private int dfs(int[][] grid, int r, int c, int idx) {
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
                return 0;
            }
            grid[r][c] = idx;
            int ans = 1;

            for (int[] move : MOVES) {
                ans += dfs(grid, r + move[0], c + move[1], idx);
            }

            return ans;
        }
    }
    
    
    class Solution2 {
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        public int largestIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            Map<Integer, Integer> areaMap = new HashMap<>();
            int label = 2;
            int res = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] == 1) {
                        int area = DFS(i, j, grid, label);
                        areaMap.put(label, area);
                        if (area > res)
                            res = area;
                        label++;
                    }
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] == 0) {
                        int curArea = 1;
                        Set<Integer> connectedLabels = new HashSet<>();
                        for (int k = 0; k < 4; k++) {
                            int x = i + directions[k][0], y = j + directions[k][1];
                            if (x < m && x >= 0 && y < n && y >= 0 && grid[x][y] >= 2)
                                connectedLabels.add(grid[x][y]);
                        }
                        for (int comp : connectedLabels) {
                            curArea += areaMap.get(comp);
                        }
                        if (curArea > res)
                            res = curArea;
                    }
            return res;
        }

        private int DFS(int i, int j, int[][] grid, int label) {
            if (i < grid.length && i >= 0 && j < grid[0].length && j >= 0 && grid[i][j] == 1) {
                grid[i][j] = label;
                int area = 1;
                area += DFS(i + 1, j, grid, label);
                area += DFS(i - 1, j, grid, label);
                area += DFS(i, j - 1, grid, label);
                area += DFS(i, j + 1, grid, label);
                return area;
            } else
                return 0;
        }
    }
}

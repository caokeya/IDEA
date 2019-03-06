package src.com.Java;

/*
我们有一组包含1和0的网格；其中1表示砖块。 当且仅当一块砖直接连接到网格的顶部，或者它至少连接着(4个方向)相邻的砖块之一时，它才不会落下。
我们会依次消除一些砖块。每当我们消除 (i, j) 位置时， 对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这个消除而落下。
返回一个数组表示每次消除操作对应落下的砖块数目。
示例 1：
输入：
grid = [[1,0,0,0],[1,1,1,0]]
hits = [[1,0]]
输出: [2]
解释: 
如果我们消除(1, 0)位置的砖块, 在(1, 1) 和(1, 2) 的砖块会落下。所以我们应该返回2。
示例 2：
输入：
grid = [[1,0,0,0],[1,1,0,0]]
hits = [[1,1],[1,0]]
输出：[0,0]
解释：
当我们消除(1, 0)的砖块时，(1, 1)的砖块已经由于上一步消除而消失了。所以每次消除操作不会造成砖块落下。注意(1, 0)砖块不会记作落下的砖块。
 */
public class _803_Bricks_Falling_When_Hit_打砖块_难 {
    /*
     * 思路： 1） 根据删除的brick 所在位置以及特性分为以下几种情况 A, 当删除index处为0， 则drop为0. #B, 当删除index处为1：
     * B.1 当删除位置的brick 不和top相连， 则drop为0. B.2 当删除位置的brick 和 top 相连 B.2.1 BFS
     * 该brick四周的各个bricks，如果各个bricks 能够通过其他bricks 到达 top，则该子brick 不会drop
     * #B.2.2否则会drop。
     */
    class Solution {
        public int[] hitBricks(int[][] grid, int[][] hits) {
            if (hits.length == 0 || hits[0].length == 0)
                return null;
            // 删除 hits中所有的bricks， 进而为下面找出所有不通过 hits 就能够到达top 的bricks 做准备。
            // 在remove中， 如果hit[i][j]在grid中为0， 同样会--，则为-1.
            removeHitBrick(grid, hits);
            // 标记所有剩余的bricks，如果该bricks 能够到达top，则设其为2.
            markRemainBricks(grid);
            // 找出所有可能会drop的bricks
            return searchFallingBrick(grid, hits);
        }

        private void removeHitBrick(int[][] grid, int[][] hits) {
            for (int i = 0; i < hits.length; i++) {
                // 如果 hits处，没有brick 则设为-1，如果有brick 则清空为0
                grid[hits[i][0]][hits[i][1]] = grid[hits[i][0]][hits[i][1]] - 1;
            }
        }

        private void markRemainBricks(int[][] grid) {
            for (int i = 0; i < grid[0].length; i++) {
                // 这里，只从第0行出发，dfs，找出所有能够到达top 的brick， 并将其设为2.
                dfs(grid, 0, i);
            }
        }

        private int[] searchFallingBrick(int[][] grid, int[][] hits) {
            int[] result = new int[hits.length];
            // 从后向前遍历hits。
            for (int i = hits.length - 1; i >= 0; i--) {
                // 如果grid 初为0，则表明hit处有brick。
                if (grid[hits[i][0]][hits[i][1]] == 0) {
                    grid[hits[i][0]][hits[i][1]] = 1;
                    // 如果hit处的brick能够到达top
                    if (isConnectToTop(grid, hits[i][0], hits[i][1])) {
                        // 找出 删掉该brick 后， 有多少 其他的bricks 会掉落。
                        // 因为从top出发能够到达的bricks 已经都设为2了，所以这些brick 不会再dfs中再次找到。
                        // 同样的，当从hit处的brick出发，找到被影响的brick后，设这些brick为2，以便于后面的hit 不会重复计数。
                        result[i] = dfs(grid, hits[i][0], hits[i][1]) - 1;
                    } else {
                        // 如果hit处的brick 无法到达top，则不会有任何brick 掉落。
                        result[i] = 0;
                    }
                }
            }
            return result;
        }

        // 判断从i,j出发，能否到达 top.
        private boolean isConnectToTop(int[][] grid, int i, int j) {
            if (i == 0)
                return true;

            if (i - 1 >= 0 && grid[i - 1][j] == 2) {
                return true;
            }
            if (i + 1 < grid.length && grid[i + 1][j] == 2) {
                return true;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 2) {
                return true;
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == 2) {
                return true;
            }
            return false;
        }

        private int dfs(int[][] data, int row, int column) {
            int arrayRow = data.length;
            int arrayLine = data[0].length;
            int effectBricks = 0;
            if (row < 0 || row >= arrayRow)
                return effectBricks;
            if (column < 0 || column >= arrayLine)
                return effectBricks;
            if (data[row][column] == 1) {
                data[row][column] = 2;
                effectBricks = 1;
                effectBricks += dfs(data, row + 1, column);
                effectBricks += dfs(data, row - 1, column);
                effectBricks += dfs(data, row, column + 1);
                effectBricks += dfs(data, row, column - 1);
            }
            return effectBricks;
        }
    }

    class Solution2 {
        public int[] hitBricks2(int[][] grid, int[][] hits) {

            int len = hits.length;
            int[] result = new int[len];

            // make all hits first
            for (int[] hit : hits) {
                grid[hit[0]][hit[1]] -= 1;
                // ^ basically which every is a brick(i.e 1) which make it a 0, it is a false
                // hit( i.e. there is no brick, it will make it a -1)
            }

            // make all the connected nodes, 2
            for (int i = 0; i < grid[0].length; i++) {
                dfs(0, i, grid);
            }

            // make all reverse hits and find the count of
            for (int k = hits.length - 1; k >= 0; k--) {
                int i = hits[k][0], j = hits[k][1];
                grid[i][j] += 1; // += 1 & not, grid[][] = 1, since, if it is fake hit, we don't want to make it
                                 // a brick again.
                if (grid[i][j] == 1 && isConnected2Top(i, j, grid)) {
                    result[k] = dfs(i, j, grid) - 1;
                }
            }

            return result;

        }

        public boolean isConnected2Top(int i, int j, int[][] grid) {
            if (i > 0 && grid[i - 1][j] == 2 
               || j > 0 && grid[i][j - 1] == 2
               || i < grid.length - 1 && grid[i + 1][j] == 2 
               || j < grid[0].length - 1 && grid[i][j + 1] == 2
               || (i == 0))
                return true;

            return false;
        }

        public int dfs(int i, int j, int[][] grid) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)

                return 0;

            grid[i][j] = 2;

            return 1 + dfs(i + 1, j, grid) + dfs(i, j + 1, grid) + dfs(i - 1, j, grid) + dfs(i, j - 1, grid);
        }
    }
}

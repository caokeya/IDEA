package src.com.Java;

import java.util.PriorityQueue;
import java.util.Queue;

/*
给定一个m x n的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
说明:
m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。
示例：
给出如下 3x6 的高度图:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]
返回 4。
 */
public class _407_Trapping_Rain_Water_II_接雨水2_难 {
    /*
     * 使用优先级队列，优先级判断条件为方块的高度。先把边缘处方块加入优先级队列，优先处理高度最低的。
     * 每取出一个方块，可以看到四个方向的方块，首先排除到已经看过或者行列不满足条件的方块，
     * 如果新方块比当前方块矮，那么最终结果加上两者之差，将新方块的高度改为当前方块高度后加入队列。
     * 如果新方块的高度大于等于当前方块，那么不作处理，将其加入队列。依次处理，直到优先级队列没有元素， 返回最终结果。
     */
    class Solution {
        private int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        // 方块类，实现了Comparable接口，用于优先级队列排序
        private class Cell implements Comparable<Cell> {
            int row;
            int col;
            int height;

            public Cell(int row, int col, int height) {
                this.row = row;
                this.col = col;
                this.height = height;
            }

            @Override
            public int compareTo(Cell cell1) {
                return height - cell1.height;
            }
        }

        public int trapRainWater(int[][] heightMap) {
            if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
                return 0;

            int m = heightMap.length, n = heightMap[0].length;
            // 由于方块类Cell实现了Comparable，优先级队列不需要定义匿名内部类comparator
            Queue<Cell> queue = new PriorityQueue<Cell>();
            boolean[][] visited = new boolean[m][n];

            // 首先放入边缘方块
            for (int i = 0; i < m; i++) {
                visited[i][0] = true;
                visited[i][n - 1] = true;
                queue.add(new Cell(i, 0, heightMap[i][0]));
                queue.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            }
            for (int j = 1; j < n - 1; j++) {
                visited[0][j] = true;
                visited[m - 1][j] = true;
                queue.add(new Cell(0, j, heightMap[0][j]));
                queue.add(new Cell(m - 1, j, heightMap[m - 1][j]));
            }

            int res = 0;
            while (!queue.isEmpty()) {
                Cell cell = queue.poll();
                for (int[] dir : dirs) {
                    int i = cell.row + dir[0], j = cell.col + dir[1];
                    // 排除不合条件的方块后分情况处理,为了方便，直接使用了两个Math.max()
                    if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                        visited[i][j] = true;
                        res += Math.max(0, cell.height - heightMap[i][j]);
                        queue.offer(new Cell(i, j, Math.max(heightMap[i][j], cell.height)));
                    }
                }
            }

            return res;
        }
    }

}

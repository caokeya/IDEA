package src.com.Java;

import java.util.LinkedList;
import java.util.Queue;

/*
在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
示例 1：
输入：[[0,1],[1,0]]
输出：1
示例 2：
输入：[[0,1,0],[0,0,0],[0,0,1]]
输出：2
示例 3：
输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
输出：1
 */
public class _934_Shortest_Bridge_最短的桥 {
    class Solution {
        public int shortestBridge(int[][] A) {
            int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            boolean[][] connected = new boolean[A.length][A[0].length];
            boolean[][] visited = new boolean[A.length][A[0].length];
            int count = 0;
            // Find a connected component
            Queue<int[]> bfs = new LinkedList<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    if (A[i][j] == 1) {
                        dfs(i, j, A, connected, bfs);
                        count++;
                        break;
                    }
                }
                if (count == 1)
                    break;
            }
            int depth = 0;
            // Find shortest path
            while (!bfs.isEmpty()) {
                int size = bfs.size();
                for (int i = 0; i < size; i++) {
                    int[] curr = bfs.poll();
                    for (int[] dir : dirs) {
                        int r = dir[0] + curr[0];
                        int c = dir[1] + curr[1];
                        if (r < 0 || c < 0 || r > A.length - 1 || c > A[r].length - 1 || connected[r][c]
                                || visited[r][c])
                            continue;
                        visited[r][c] = true;
                        if (A[r][c] == 1)
                            return depth;
                        else
                            bfs.add(new int[] { r, c });
                    }
                }
                depth++;
            }
            return -1;
        }

        void dfs(int i, int j, int[][] A, boolean[][] connected, Queue<int[]> bfs) {
            if (i < 0 || j < 0 || i > A.length - 1 || j > A[i].length - 1 || connected[i][j] || A[i][j] == 0)
                return;
            connected[i][j] = true;
            bfs.add(new int[] { i, j });

            dfs(i - 1, j, A, connected, bfs);
            dfs(i + 1, j, A, connected, bfs);
            dfs(i, j - 1, A, connected, bfs);
            dfs(i, j + 1, A, connected, bfs);
        }
    }
}

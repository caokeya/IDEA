package src.com.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/*
你被请来给一个要举办高尔夫比赛的树林砍树. 树林由一个非负的二维数组表示， 在这个数组中：
    0 表示障碍，无法触碰到.
    1 表示可以行走的地面.
    比1大的数 表示一颗允许走过的树的高度.
你被要求按照树的高度从低向高砍掉所有的树，每砍过一颗树，树的高度变为1。
你将从（0，0）点开始工作，你应该返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
可以保证的是，没有两棵树的高度是相同的，并且至少有一颗树需要你砍。
示例 1:
输入: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
输出: 6
示例 2:
输入: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
输出: -1
示例 3:
输入: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
输出: 6
解释: (0,0) 位置的树，你可以直接砍去，不用算步数
 */
public class _675_Cut_Off_Trees_for_Golf_Event_为高尔夫比赛砍树_难 {
    class Solution {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        public int cutOffTree(List<List<Integer>> forest) {
            // 将所有树的位置保存下来
            List<int[]> trees = new ArrayList();
            for (int r = 0; r < forest.size(); ++r) {
                for (int c = 0; c < forest.get(0).size(); ++c) {
                    int v = forest.get(r).get(c);
                    if (v > 1)
                        trees.add(new int[] { v, r, c }); // {height, row index, column index}
                }
            }

            // 按照树的高度由低到高排序
            Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

            int ans = 0, sr = 0, sc = 0;
            for (int[] tree : trees) {
                // 从[sr, sc]到[tree[1], tree[2]]去 cut tree 的最短路径
                int d = dist(forest, sr, sc, tree[1], tree[2]);
                if (d < 0)
                    return -1;
                ans += d;
                sr = tree[1];
                sc = tree[2];
            }

            return ans;
        }

        /*
         * 用BFS计算距离
         */
        public int dist(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
            int R = forest.size(), C = forest.get(0).size();
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.add(new int[] { sr, sc, 0 });
            boolean[][] seen = new boolean[R][C];
            seen[sr][sc] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == tr && cur[1] == tc)
                    return cur[2];
                for (int di = 0; di < 4; ++di) {
                    int r = cur[0] + dr[di];
                    int c = cur[1] + dc[di];
                    if (0 <= r && r < R && 0 <= c && c < C && !seen[r][c] && forest.get(r).get(c) > 0) {
                        seen[r][c] = true;
                        queue.add(new int[] { r, c, cur[2] + 1 });
                    }
                }
            }
            return -1;
        }
    }

    class Solution2 {
        int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };// 四个方向
        int[][] dist; // 保存当前出发点到所有点的最断距离

        public int cutOffTree(List<List<Integer>> forest) {
            int result = 0;
            int rows = forest.size();
            int cols = forest.get(0).size();
            int[][] matrix = new int[rows][cols];
            // TreeMap有自动键值排序的功能，用其存储<树高，与树所在矩阵的坐标>
            TreeMap<Integer, int[]> map = new TreeMap<Integer, int[]>();
            dist = new int[rows][cols];

            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = forest.get(i).get(j);
                    map.put(matrix[i][j], new int[] { i, j });
                }

            // 这里拿到的键值均是从小到大有序的
            Set<Integer> keys = map.keySet();
            // 初始坐标
            int[] start = { 0, 0 };
            for (int key : keys) {
                if (key > 0) {
                    int[] end = map.get(key); // 拿到当前最小高度的树的坐标
                    minDist(start, matrix); // 求出出发点到其它所有点的最短距离
                    int d = dist[end[0]][end[1]]; // 拿到出发点到当前最小树高的距离
                    if (d == Integer.MAX_VALUE) // 若无法到达则返回-1
                        return -1;
                    result += d; // 进行累加
                    start = end; // 将当前最小高度的树作为下一轮的出发点
                }
            }
            return result;
        }

        // 求出给定的点到其它点之间的最短距离。
        void minDist(int[] start, int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            // 初始化dist数组，默认为MAX
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    dist[i][j] = Integer.MAX_VALUE;

            // 队列中存放点集合
            Queue<int[]> q = new LinkedList<int[]>();
            q.add(start); // 出发点入队
            dist[start[0]][start[1]] = 0; // 到自己的距离为0

            while (!q.isEmpty()) {
                int[] p = q.poll();
                // 可选的四个方向
                for (int[] dir : direct) {
                    int x = p[0];
                    int y = p[1];
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    int[] np = { nx, ny };
                    // 可入队的点要满足：1.格式 2.不是障碍物 3.出发点到它的距离小于其本身在dist数组里的距离
                    if (nx < rows && nx >= 0 && ny < cols && ny >= 0 && matrix[nx][ny] != 0
                            && dist[nx][ny] > dist[x][y] + 1) {
                        q.add(np);
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }

            }

        }

    }
}

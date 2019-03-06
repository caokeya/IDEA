package src.com.Java;

import java.util.ArrayList;

/*
给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
每个人都可能不喜欢其他人，那么他们不应该属于同一组。
形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。
示例 1：
输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
输出：true
解释：group1 [1,4], group2 [2,3]
示例 2：
输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
输出：false
示例 3：
输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
输出：false
 */
public class _886_Possible_Bipartition_可能的二分法 {
    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            int[] color = new int[N + 1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] dis : dislikes) {
                graph[dis[0]].add(dis[1]);
                graph[dis[1]].add(dis[0]);
            }

            for (int i = 1; i <= N; i++) {
                if (color[i] == 0 && !dfs(i, color, graph, 1)) {
                    return false;
                }
            }

            return true;
        }

        // 0 -- unvisited
        // 1 -- group 1
        // 2 -- group 2
        private boolean dfs(int curr, int[] color, ArrayList<Integer>[] graph, int nextColor) {
            if (color[curr] != 0) {
                return color[curr] != nextColor;
            }
            int currColor = nextColor;
            color[curr] = currColor;
            nextColor = nextColor == 2 ? 1 : 2;
            for (int next : graph[curr]) {
                if (color[next] == currColor) {
                    return false;
                }

                if (color[next] == 0 && !dfs(next, color, graph, nextColor)) {
                    return false;
                }
            }

            return true;
        }
    }
}

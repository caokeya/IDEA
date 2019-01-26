package src.com.Java;

import java.util.ArrayList;
import java.util.List;

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
            int[] colors = new int[N + 1];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; ++i)
                graph.add(new ArrayList<Integer>());
            for (int i = 0; i < dislikes.length; ++i) {
                graph.get(dislikes[i][0]).add(dislikes[i][1]);
                graph.get(dislikes[i][1]).add(dislikes[i][0]);
            }
            for (int i = 1; i <= N; ++i) {
                if (colors[i] == 0) {
                    if (!dfs(graph, colors, i, 1))
                        return false;
                }
            }
            return true;
        }

        private boolean dfs(List<List<Integer>> graph, int[] colors, int cur, int color) {
            if (colors[cur] == -1 * color)
                return false;
            if (colors[cur] == color)
                return true;
            colors[cur] = color;
            for (int nei : graph.get(cur)) {
                if (!dfs(graph, colors, nei, -1 * color))
                    return false;
            }
            return true;
        }
    }
}

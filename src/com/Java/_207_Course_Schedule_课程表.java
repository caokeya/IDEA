package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
 现在你总共有 n 门课需要选，记为 0 到 n-1。
 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 示例 1:
 输入: 2, [[1,0]]
 输出: true
 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 示例 2:
 输入: 2, [[1,0],[0,1]]
 输出: false
 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 */
public class _207_Course_Schedule_课程表 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> edges = new ArrayList<List<Integer>>();

            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<Integer>());
            }

            for (int[] pair : prerequisites) {
                edges.get(pair[0]).add(pair[1]);
            }

            return !hasCircle(edges);
        }

        private boolean hasCircle(List<List<Integer>> edges) {
            boolean[] visited = new boolean[edges.size()];
            boolean[] path = new boolean[edges.size()];

            for (int i = 0; i < edges.size(); i++) {
                if (!visited[i] && dfs(i, edges, visited, path))
                    return true;
            }

            return false;
        }

        private boolean dfs(int i, List<List<Integer>> edges, boolean[] visited, boolean[] path) {
            // has circle
            if (path[i]) return true;

            // visited
            if (visited[i]) return false;

            visited[i] = true;
            path[i] = true;

            for (int edge : edges.get(i)) {
                if (dfs(edge, edges, visited, path))
                    return true;
            }

            path[i] = false;
            return false;
        }
    }
}

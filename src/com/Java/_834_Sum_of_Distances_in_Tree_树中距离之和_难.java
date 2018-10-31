package src.com.Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
示例 1:
输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
输出: [8,12,6,10,10,10]
解释: 
如下为给定的树的示意图：
  0
 / \
1   2
   /|\
  3 4 5
我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 */
public class _834_Sum_of_Distances_in_Tree_树中距离之和_难 {
    class Solution {
        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            List<Integer>[] adj = new List[N];
            for (int i = 0; i < N; i++)
                adj[i] = new LinkedList<>();
            for (int[] e : edges) {
                adj[e[0]].add(e[1]);
                adj[e[1]].add(e[0]);
            }
            int[] res = new int[N], count = new int[N];
            boolean[] visited = new boolean[N];
            countDown(adj, 0, res, count, visited);
            Arrays.fill(visited, false);
            countUp(adj, 0, count[0], res, count, visited);
            return res;
        }

        public void countDown(List<Integer>[] adj, int node, int[] res, int[] count, boolean[] visited) {
            visited[node] = true;
            for (int v : adj[node]) {
                if (!visited[v]) {
                    countDown(adj, v, res, count, visited);
                    count[node] += count[v];
                    res[node] += res[v] + count[v];
                }
            }
            count[node]++;
        }

        public void countUp(List<Integer>[] adj, int node, int total, int[] res, int[] count, boolean[] visited) {
            visited[node] = true;
            for (int v : adj[node]) {
                if (!visited[v]) {
                    res[v] += res[node] - res[v] - count[v] + total - count[v];
                    countUp(adj, v, total, res, count, visited);
                }
            }
        }
    }
}

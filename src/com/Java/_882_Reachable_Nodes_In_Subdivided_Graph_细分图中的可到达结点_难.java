package src.com.Java;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
从具有 0 到 N-1 的结点的无向图（“原始图”）开始，对一些边进行细分。
该图给出如下：edges[k] 是整数对 (i, j, n) 组成的列表，使 (i, j) 是原始图的边。
n 是该边上新结点的总数
然后，将边 (i, j) 从原始图中删除，将 n 个新结点 (x_1, x_2, ..., x_n) 添加到原始图中，
将 n+1 条新边 (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) 添加到原始图中。
现在，你将从原始图中的结点 0 处出发，并且每次移动，你都将沿着一条边行进。
返回最多 M 次移动可以达到的结点数。
示例 1：
输入：edges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3
输出：13
解释：
在 M = 6 次移动之后在最终图中可到达的结点如下所示。
示例 2：
输入：edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4
输出：23
 */
public class _882_Reachable_Nodes_In_Subdivided_Graph_细分图中的可到达结点_难 {
    /*
         * 将边存储到另一个2D哈希表e中，以便通过e[i][j]更容易地获得两个节点之间的长度。
    * seen[i]表示我们可以到达节点i，并看到[i]向左移动。
         * 优先队列pq存储状态(向左移动，节点索引)。 
         * 每次当我们从pq中跳出时，我们得到的状态是剩下的移动数最多的。
    * For every edge e[i][j]:
    * res += min(seen.getOrDefault(i, 0) + seen.getOrDefault(j, 0), e[i][j])
     */
    class Solution {
        public int reachableNodes(int[][] edges, int M, int N) {
            HashMap<Integer, HashMap<Integer, Integer>> e = new HashMap<>();
            for (int i = 0; i < N; ++i)
                e.put(i, new HashMap<>());
            for (int[] edge : edges) {
                e.get(edge[0]).put(edge[1], edge[2]);
                e.get(edge[1]).put(edge[0], edge[2]);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
            pq.offer(new int[] { M, 0 });
            HashMap<Integer, Integer> seen = new HashMap<>();
            while (!pq.isEmpty()) {
                int moves = pq.peek()[0], i = pq.peek()[1];
                pq.poll();
                if (!seen.containsKey(i)) {
                    seen.put(i, moves);
                    for (int j : e.get(i).keySet()) {
                        int moves2 = moves - e.get(i).get(j) - 1;
                        if (!seen.containsKey(j) && moves2 >= 0)
                            pq.offer(new int[] { moves2, j });
                    }
                }
            }
            int res = seen.size();
            for (int[] edge : edges) {
                int a = seen.getOrDefault(edge[0], 0);
                int b = seen.getOrDefault(edge[1], 0);
                res += Math.min(a + b, edge[2]);
            }
            return res;
        }
    }
}

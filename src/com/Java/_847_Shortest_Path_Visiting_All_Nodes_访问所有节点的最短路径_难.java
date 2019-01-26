package src.com.Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。 
graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
示例 1：
输入：[[1,2,3],[0],[0],[0]]
输出：4
解释：一个可能的路径为 [1,0,2,0,3]
示例 2：
输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
输出：4
解释：一个可能的路径为 [0,1,4,2,3]
 */
public class _847_Shortest_Path_Visiting_All_Nodes_访问所有节点的最短路径_难 {
    class Solution {
        class State {
            public int cover, head;

            public State(int c, int h) {
                cover = c;
                head = h;
            }
        }
        /*
        用一个二维矩阵来记录从一个点到这些点的距离。
        dp[0][3(00000…00011)]= 2表示从0到0,1的距离是2
        dp[1][7(00000…00111)]= 3表示从1到0、1、2的距离是3
        在BFS之后，我们将知道所有节点的距离，比较dp[0][11111…][11111](表示起点0经过所有节点)，dp[1][11111…11111]
        …dp(n - 1)[11111…我们会得到结果的。
         */
        public int shortestPathLength(int[][] graph) {
            int[][] dp = new int[graph.length][1 << graph.length];
            Queue<State> queue = new LinkedList<>();
            for (int i = 0; i < graph.length; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][1 << i] = 0;
                queue.offer(new State(1 << i, i));
            }
            while (!queue.isEmpty()) {
                State state = queue.poll();
                for (int next : graph[state.head]) {
                    int nextMask = state.cover | 1 << next;
                    if (dp[next][nextMask] > dp[state.head][state.cover] + 1) {
                        dp[next][nextMask] = dp[state.head][state.cover] + 1;
                        queue.offer(new State(nextMask, next));
                    }
                }
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < graph.length; i++) {
                res = Math.min(res, dp[i][(1 << graph.length) - 1]);
            }
            return res;
        }
    }
}

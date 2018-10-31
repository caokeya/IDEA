package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边), 我们停止。
现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。 更具体地说, 存在一个自然数 K,  无论选择从哪里开始行走, 我们走了不到 K 步后必能停止在一个终点。
哪些节点最终是安全的？ 结果返回一个有序的数组。
该有向图有 N 个节点，标签为 0, 1, ..., N-1, 其中 N 是 graph 的节点数.  图以以下的形式给出: graph[i] 是节点 j 的一个列表，满足 (i, j) 是图的一条有向边。
示例：
输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
输出：[2,4,5,6]

 */
public class _802_Find_Eventual_Safe_States_找到最终的安全状态 {
    //记录可以到达的点，如果没有环型结构，就加入结果
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer> res = new ArrayList<>();
            if (graph == null || graph.length == 0)
                return res;

            int nodeCount = graph.length;
            int[] visited = new int[nodeCount];

            for (int i = 0; i < nodeCount; i++) {
                if (dfs(graph, i, visited))
                    res.add(i);
            }

            return res;
        }

        public boolean dfs(int[][] graph, int start, int[] visited) {
            if (visited[start] != 0)
                return visited[start] == 1;

            visited[start] = 2;// 不安全的
            for (int newNode : graph[start]) {
                if (!dfs(graph, newNode, visited))
                    return false;
            }
            visited[start] = 1;// 安全的

            return true;
        }
    }

    class Solution2 {
        int[] visited;
        int[][] graph;

        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            this.graph = graph;
            visited = new int[n];
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0)
                    dfs(i);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i] == 1)
                    res.add(i);
            }
            return res;
        }

        boolean dfs(int i) {
            visited[i] = 2;
            for (int next : graph[i]) {
                if (visited[next] == 1)// 安全的
                    continue;
                if (visited[next] == 2 || !dfs(next)) {// 不安全的
                    return false;
                }
            }
            visited[i] = 1;
            return true;
        }
    }
}

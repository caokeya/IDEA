package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点
（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
示例:
输入: [[1,2], [3], [3], []] 
输出: [[0,1,3],[0,2,3]] 
解释: 图是这样的:
0--->1
|    |
v    v
2--->3
这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
 */
public class _797_All_Paths_From_Source_to_Target_所有可能的路径 {
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();

            path.add(0);
            dfsSearch(graph, 0, res, path);

            return res;
        }

        private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
            if (node == graph.length - 1) {
                res.add(new ArrayList<Integer>(path));
                return;
            }

            for (int nextNode : graph[node]) {
                path.add(nextNode);
                dfsSearch(graph, nextNode, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
}

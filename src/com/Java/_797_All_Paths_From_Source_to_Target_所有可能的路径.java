package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
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
            List<List<Integer>> ans = new ArrayList<>();
            if (graph == null || graph.length == 0)
                return ans;
            List<Integer> tempList = new ArrayList<>();
            tempList.add(0);
            helper(graph, ans, tempList, 0);
            return ans;
        }

        private void helper(int[][] grid, List<List<Integer>> ans, List<Integer> tempList, int node) {
            int len = grid.length;
            if (node != len - 1) {
                for (int i = 0; i < grid[node].length; i++) {
                    tempList.add(grid[node][i]);
                    helper(grid, ans, tempList, grid[node][i]);
                    tempList.remove(tempList.size() - 1);
                }
            } else {
                ans.add(new ArrayList<>(tempList));
            }
        }
    }

    class Solution2 {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            if (graph == null || graph.length == 0)
                return res;
            List<Integer> list = new ArrayList<>();
            list.add(0);
            find(graph, 0, list, res);
            return res;
        }

        public void find(int[][] graph, int idx, List<Integer> list, List<List<Integer>> res) {
            if (graph[idx] == null || graph[idx].length == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int point : graph[idx]) {
                list.add(point);
                find(graph, point, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}

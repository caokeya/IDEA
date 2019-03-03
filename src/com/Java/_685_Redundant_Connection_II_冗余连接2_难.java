package com.Java;

/*
在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u and v和顶点的边，其中父节点u是子节点v的一个父节点。
返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
示例 1:
输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的有向图如下:
  1
 / \
v   v
2-->3
示例 2:
输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
输出: [4,1]
解释: 给定的有向图如下:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
 */
public class _685_Redundant_Connection_II_冗余连接2_难 {
    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int[] parents = new int[edges.length + 1];
            int[] roots = new int[edges.length + 1];
            int[] first = null;
            int[] second = null;
            int[] last = null;
            for (int[] edge : edges) {
                int parent = edge[0];
                int child = edge[1];
                // if child has more than 1 parent
                if (parents[child] != 0) {
                    first = new int[] { parents[child], child };
                    second = edge;
                    continue;
                } else {
                    parents[child] = parent;
                }

                int pRoot = findRoot(roots, parent);
                if (pRoot == child) {
                    last = edge;
                } else {
                    roots[child] = pRoot;
                }
            }

            if (last == null) {
                return second;
            }

            if (second == null) {
                return last;
            }

            return first;
        }

        private int findRoot(int[] ds, int i) {
            return ds[i] == 0 ? i : (ds[i] = findRoot(ds, ds[i]));
        }
    }
    
    class Solution2 {
        /*
        1) Check whether there is a node having two parents. 
        If so, store them as candidates A and B, and set the second edge invalid. 
        2) Perform normal union find. 
        If the tree is now valid 
               simply return candidate B
        else if candidates not existing 
               we find a circle, return current edge; 
        else 
               remove candidate A instead of B.
        */
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int[] can1 = { -1, -1 };
            int[] can2 = { -1, -1 };
            int[] parent = new int[edges.length + 1];
            for (int i = 0; i < edges.length; i++) {
                if (parent[edges[i][1]] == 0) {
                    parent[edges[i][1]] = edges[i][0];
                } else {
                    can2 = new int[] { edges[i][0], edges[i][1] };
                    can1 = new int[] { parent[edges[i][1]], edges[i][1] };
                    edges[i][1] = 0;
                }
            }
            for (int i = 0; i < edges.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][1] == 0) {
                    continue;
                }
                int child = edges[i][1], father = edges[i][0];
                if (root(parent, father) == child) {
                    if (can1[0] == -1) {
                        return edges[i];
                    }
                    return can1;
                }
                parent[child] = father;
            }
            return can2;
        }

        int root(int[] parent, int i) {
            if (parent[i] != i) {
                parent[i] = root(parent, parent[i]);
            }
            return parent[i];
        }
    }
}

package src.com.Java;

import java.util.Arrays;

/*
在本问题中, 树指的是一个连通且无环的无向图。
输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
示例 1：
输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的无向图为:
  1
 / \
2 - 3
示例 2：
输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
解释: 给定的无向图为:
5 - 1 - 2
    |   |
    4 - 3
 */
public class _684_Redundant_Connection_冗余连接 {
    class Solution {
        class UnionFindSet {
            private int[] parents_;
            private int[] ranks_;

            public UnionFindSet(int n) {
                parents_ = new int[n + 1];
                ranks_ = new int[n + 1];
                for (int i = 1; i < n; i++) {
                    parents_[i] = i;
                    ranks_[i] = 0;
                }

            }

            public boolean union(int u, int v) {
                int pu = find(u);
                int pv = find(v);
                if (pu == pv)
                    return false;
                if (ranks_[pv] > ranks_[pu]) {
                    parents_[pu] = pv;
                } else if (ranks_[pu] > ranks_[pv]) {
                    parents_[pv] = pu;
                } else {
                    parents_[pv] = pu;
                    ranks_[pu] += 1;
                }
                return true;
            }

            public int find(int n) {
                while (n != parents_[n]) {
                    parents_[n] = parents_[parents_[n]];
                    n = parents_[n];
                }
                return n;
            }
        }

        public int[] findRedundantConnection(int[][] edges) {
            UnionFindSet ufs = new UnionFindSet(edges.length);
            for (int i = 0; i < edges.length; i++) {
                if (!ufs.union(edges[i][0], edges[i][1])) {
                    return edges[i];
                }
            }
            return null;
        }
    }

    class Solution2 {
        public int[] findRedundantConnection(int[][] edges) {
            int[] parent = new int[edges.length + 1]; // values are [1, n]! so size is n + 1
            Arrays.fill(parent, -1);
            for (int[] edge : edges) {
                int xset = find(parent, edge[0]);
                int yset = find(parent, edge[1]);
                if (xset == yset) { // cicle detected
                    return edge;
                }
                // union
                parent[xset] = yset;
            }
            return new int[2];
        }

        public int find(int[] parent, int i) {
            if (parent[i] == -1) { // root
                return i;
            }
            parent[i] = find(parent, parent[i]);
            return parent[i];
        }
    }

}

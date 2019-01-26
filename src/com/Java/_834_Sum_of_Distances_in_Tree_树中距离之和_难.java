package src.com.Java;

import java.util.*;

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
    /*
    我们把结点0作为根结点来解。
    初始化一个哈希集树数组，树[i]包含所有连接到i的节点。
    初始化一个数组count, count[i]计数子树i中的所有节点。
    初始化一个res数组，res[i]计数子树i中的距离和。
    后序dfs遍历、更新计数和res:
    count[根]= sum(count[i]) + 1
    res[根]= sum(res[i]) + sum(count[i])
    预序dfs遍历，更新res:
    当我们把根结点从父结点移到子结点i时，count[i]点离根结点更近1个，n - count[i]节点离根结点更近1个。
     */
    // 后序DFS + 先序DFS

    class Solution {
        List<HashSet<Integer>> tree;
        int N;
        int[] sum;         // total sum of distance in subtree i
        int[] count;       // number of all nodes in the subtree i, including node i itself

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            this.N = N;

            tree = new ArrayList<HashSet<Integer>>();
            sum = new int[N];
            count = new int[N];

            // 图中的每个点初始化一个集合
            for (int i = 0; i < N; i++) {
                tree.add(new HashSet<Integer>());
            }
            // 遍历每条边，添加每个点的邻居
            for (int[] e : edges) {
                tree.get(e[0]).add(e[1]);
                tree.get(e[1]).add(e[0]);
            }

            dfs(0, new HashSet<Integer>());

            dfs2(0, new HashSet<Integer>());

            return sum;
        }

        // Post order dfs traversal
        public void dfs(int root, HashSet<Integer> seen) {
            // 标记为已访问
            seen.add(root);

            for (int i : tree.get(root)) {
                if (!seen.contains(i)) {
                    // 向子树递归
                    dfs(i, seen);
                    // 更新当前树包含的节点个数
                    count[root] += count[i];
                    // 当前树距离和 += 子树距离和 + 子树节点个数
                    sum[root] += sum[i] + count[i];
                }
            }

            count[root]++;  // 加上1，表示当前节点自己
        }

        // Pre order dfs traversal
        public void dfs2(int root, HashSet<Integer> seen) {
            // 标记为已访问
            seen.add(root);

            for (int i : tree.get(root)) {
                if (!seen.contains(i)) {
                    // When we move our root from parent to its child i,
                    // count[i] points get 1 closer to root, n - count[i] nodes get 1 futhur to root.
                    // 子树距离和 = 当前树距离和 - 子树节点个数 + 其余节点个数
                    sum[i] = sum[root] - count[i] + (N - count[i]);
                    //向子树递归
                    dfs2(i, seen);
                }
            }
        }
    }
}

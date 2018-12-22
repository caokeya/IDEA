package src.com.Java;

/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
示例:
输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class _096_Unique_Binary_Search_Trees_不同的二叉树 {
    /*
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*
    To build a tree contains {1,2,3,4,5}.
    First we pick 1 as root, for the left sub tree, there are none;
    for the right sub tree, we need count how many possible trees are there constructed from {2,3,4,5},
    apparently it's the same number as {1,2,3,4}.
    So the total number of trees under "1" picked as root is dp[0] * dp[4] = 14. (assume dp[0] =1).
    Similarly, root 2 has dp[1]*dp[3] = 5 trees. root 3 has dp[2]*dp[2] = 4, root 4 has dp[3]*dp[1]= 5 and root 5 has dp[0]*dp[4] = 14.
    Finally sum the up and it's done.
     */
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int level = 2; level <= n; level++)
                for (int root = 1; root <= level; root++)
                    dp[level] += dp[level - root] * dp[root - 1];
            return dp[n];
        }
    }
}

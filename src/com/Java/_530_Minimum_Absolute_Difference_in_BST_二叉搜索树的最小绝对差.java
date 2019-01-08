package src.com.Java;

/*
给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
示例 :
输入:
   1
    \
     3
    /
   2
输出:
1
解释:
最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class _530_Minimum_Absolute_Difference_in_BST_二叉搜索树的最小绝对差 {
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

    class Solution {
        int dif = Integer.MAX_VALUE;
        int pre = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            helper(root);
            return dif;
        }

        public void helper(TreeNode root) {
            if (root == null) return;
            helper(root.left);
            dif = Math.min(dif, Math.abs(root.val - pre));
            pre = root.val;
            helper(root.right);
        }
    }
}

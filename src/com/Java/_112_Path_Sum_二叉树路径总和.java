package src.com.Java;

public class _112_Path_Sum_二叉树路径总和 {
    /**
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

    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;

            if (root.left == null && root.right == null && sum - root.val == 0)
                return true;

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}

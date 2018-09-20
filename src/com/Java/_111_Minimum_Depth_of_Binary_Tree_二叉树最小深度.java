package src.com.Java;

public class _111_Minimum_Depth_of_Binary_Tree_二叉树最小深度 {
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
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

        }
    }
}

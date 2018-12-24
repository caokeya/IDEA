package src.com.Java;

/*
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。
示例:
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
 */
public class _111_Minimum_Depth_of_Binary_Tree_二叉树最小深度 {
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

    public class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

        }
    }

    class Solution2 {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int[] global = {Integer.MAX_VALUE};
            dfs(root, 0, global);
            return global[0];
        }

        private void dfs(TreeNode root, int prefix, int[] global) {
            if (root == null) {
                return;
            }
            prefix++;
            if (root.left == null && root.right == null) {
                global[0] = Math.min(global[0], prefix);
                return;
            }
            dfs(root.left, prefix, global);
            dfs(root.right, prefix, global);
        }
    }
}

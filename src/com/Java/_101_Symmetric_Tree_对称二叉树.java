package src.com.Java;
/*
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
 */
public class _101_Symmetric_Tree_对称二叉树 {
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

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return isMirror(root.left, root.right);
        }

        public boolean isMirror(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if (p == null || q == null)
                return false;
            return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
    }
}

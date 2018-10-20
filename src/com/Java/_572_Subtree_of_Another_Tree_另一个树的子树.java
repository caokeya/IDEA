package src.com.Java;

/*
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
示例 1:
给定的树 s:
     3
    / \
   4   5
  / \
 1   2
给定的树 t：
   4 
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 */
public class _572_Subtree_of_Another_Tree_另一个树的子树 {
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
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            if (isSameNode(s, t)) {
                return true;
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);

        }

        private boolean isSameNode(TreeNode s, TreeNode t) {
            if (s == null & t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.val != t.val) {
                return false;
            }
            return isSameNode(s.left, t.left) && isSameNode(s.right, t.right);
        }
    }
}

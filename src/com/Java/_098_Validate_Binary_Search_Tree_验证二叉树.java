package src.com.Java;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
示例 1:
输入:
    2
   / \
  1   3
输出: true
 */
public class _098_Validate_Binary_Search_Tree_验证二叉树 {
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
        public boolean isValidBST(TreeNode root) {
            long uppermost = Long.MAX_VALUE;
            long lowermost = Long.MIN_VALUE;
            return dfs(root, uppermost, lowermost);
        }

        private boolean dfs(TreeNode root, long uppermost, long lowermost) {
            if (root == null) return true;
            if (root.val <= lowermost || root.val >= uppermost) return false;
            return dfs(root.left, root.val, lowermost) && dfs(root.right, uppermost, root.val);
        }
    }
}

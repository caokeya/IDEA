package src.com.Java;
/*
二叉搜索树中的两个节点被错误地交换。
请在不改变其结构的情况下，恢复这棵树。
示例 1:
输入: [1,3,null,null,2]

   1
  /
 3
  \
   2
输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
 */
public class _099_Recover_Binary_Search_Tree_恢复二叉树_难 {
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
        private TreeNode firstNode;
        private TreeNode secondNode;
        private TreeNode preNode;

        public void recoverTree(TreeNode root) {

            helper(root);
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }

        private void helper(TreeNode node) {
            if (node == null)
                return;
            helper(node.left);
            if (preNode != null && preNode.val >= node.val) {
                if (firstNode == null)
                    firstNode = preNode;
                secondNode = node;
            }
            preNode = node;
            helper(node.right);
        }
    }
}

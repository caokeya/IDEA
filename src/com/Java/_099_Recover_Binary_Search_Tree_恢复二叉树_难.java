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
        TreeNode first;
        TreeNode second;
        TreeNode pre;

        public void recoverTree(TreeNode root) {
            first = null;
            second = null;
            pre = null;
            recover(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        private void recover(TreeNode root) {
            if (root == null) return;
            recover(root.left);
            if (first == null && (pre == null || pre.val >= root.val)) {
                first = pre;
            }
            if (first != null && pre.val >= root.val) {
                second = root;
            }
            pre = root;
            recover(root.right);
        }
    }
}

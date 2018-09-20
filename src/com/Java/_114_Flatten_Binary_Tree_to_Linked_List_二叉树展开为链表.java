package src.com.Java;

public class _114_Flatten_Binary_Tree_to_Linked_List_二叉树展开为链表 {
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
        public TreeNode lastNode = null;

        public void flatten(TreeNode root) {
            // 依次先序遍历二叉树进行拼接。先拼接根，再拼接左边，再拼接右边。记得先记录左右，因为flatten之后树的结构回改变。
            if (root == null) {
                return;
            }
            if (lastNode != null) {
                lastNode.right = root;
                lastNode.left = null;
            }
            lastNode = root;
            TreeNode left = root.left;
            TreeNode right = root.right;
            flatten(left);
            flatten(right);
        }
    }
}

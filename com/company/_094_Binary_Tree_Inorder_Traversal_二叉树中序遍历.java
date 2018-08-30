package com.company;

import java.util.ArrayList;
import java.util.List;

public class _094_Binary_Tree_Inorder_Traversal_二叉树中序遍历 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }
}

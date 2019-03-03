package com.Java;

import java.util.ArrayList;
import java.util.List;

public class _145_Binary_Tree_Postorder_Traversal_二叉树的后序遍历_难 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            helper(root, res);
            return res;
        }

        public void helper(TreeNode root, List<Integer> res) {
            if (root == null)
                return;
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }
}

package com.Java;

/*
给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
二叉搜索树保证具有唯一的值。
示例 1：
输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
输出：32
示例 2：
输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
输出：23
 */
public class _938_Range_Sum_of_BST_二叉搜索树的范围和 {
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
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null)
                return 0; // base case.
            if (root.val < L)
                return rangeSumBST(root.right, L, R); // left branch excluded.
            if (root.val > R)
                return rangeSumBST(root.left, L, R); // right branch excluded.
            return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R); // count in both children.
        }
    }
}

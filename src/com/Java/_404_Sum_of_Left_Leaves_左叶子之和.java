package com.Java;

/*
计算给定二叉树的所有左叶子之和。
示例：
    3
   / \
  9  20
    /  \
   15   7
在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class _404_Sum_of_Left_Leaves_左叶子之和 {
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
        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            return summing(root, false);
        }

        public int summing(TreeNode root, boolean isLeft) {
            if (root == null) {
                return 0;
            }
            if (isLeft) {
                if (root.left == null && root.right == null) {
                    return root.val;
                }
            }
            return sum + summing(root.left, true) + summing(root.right, false);
        }
    }
}

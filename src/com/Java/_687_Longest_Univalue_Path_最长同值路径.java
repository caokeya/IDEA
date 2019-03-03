package com.Java;

/*
给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
注意：两个节点之间的路径长度由它们之间的边数表示。
示例 1:
输入:
              5
             / \
            4   5
           / \   \
          1   1   5
输出:
2
示例 2:
输入:
              1
             / \
            4   5
           / \   \
          4   4   5
输出:
2
 */
public class _687_Longest_Univalue_Path_最长同值路径 {
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
        public int longestUnivaluePath(TreeNode root) {
            int[] res = new int[1];
            if (root != null)
                dfs(root, res);
            return res[0];
        }

        private int dfs(TreeNode node, int[] res) {
            int l = node.left != null ? dfs(node.left, res) : 0; // Longest-Univalue-Path-Start-At - left child
            int r = node.right != null ? dfs(node.right, res) : 0; // Longest-Univalue-Path-Start-At - right child
            int resl = node.left != null && node.left.val == node.val ? l + 1 : 0; // Longest-Univalue-Path-Start-At -
                                                                                   // node, and go left
            int resr = node.right != null && node.right.val == node.val ? r + 1 : 0; // Longest-Univalue-Path-Start-At -
                                                                                     // node, and go right
            res[0] = Math.max(res[0], resl + resr); // Longest-Univalue-Path-Across - node
            return Math.max(resl, resr);
        }
    }

    class Solution2 {
        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            helper(root);
            return max;
        }

        private int helper(TreeNode root) {
            if (root == null)
                return 0;
            int fromLeft = helper(root.left);
            int fromRight = helper(root.right);

            if (root.left != null && root.val == root.left.val) {
                fromLeft++;
            } else {
                fromLeft = 0;
            }
            if (root.right != null && root.val == root.right.val) {
                fromRight++;
            } else {
                fromRight = 0;
            }

            max = Math.max(max, fromLeft + fromRight);
            // System.out.println(max);
            return Math.max(fromLeft, fromRight);
        }
    }
}

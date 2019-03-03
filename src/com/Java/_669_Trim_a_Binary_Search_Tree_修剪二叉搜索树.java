package com.Java;

/*
给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
示例 1:
输入: 
    1
   / \
  0   2

  L = 1
  R = 2
输出: 
    1
      \
       2
示例 2:
输入: 
    3
   / \
  0   4
   \
    2
   /
  1
  L = 1
  R = 3
输出: 
      3
     / 
   2   
  /
 1
 */
public class _669_Trim_a_Binary_Search_Tree_修剪二叉搜索树 {
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
        public TreeNode trimBST(TreeNode root, int L, int R) {
            // base case
            if (root == null)
                return null;

            // recurse
            if (root.val < L) { // ignore left sub-tree
                return trimBST(root.right, L, R);

            } else if (root.val > R) {
                return trimBST(root.left, L, R);

            } else { // L <= root.val <= R
                root.left = trimBST(root.left, L, R);
                root.right = trimBST(root.right, L, R);
                return root;
            }
        }
    }
}

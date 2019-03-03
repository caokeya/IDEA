package com.Java;

import java.util.ArrayList;
import java.util.List;
/*
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]
 */
public class _103_Binary_Tree_Zigzag_Level_Order_Traversal_二叉树的锯齿形遍历 {
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

    public class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;
            helper(root, 0, res);
            // Collections.reverse(res);
            return res;
        }

        private void helper(TreeNode root, int level, List<List<Integer>> res) {
            if (root == null)
                return;
            if (res.size() == level)
                res.add(new ArrayList<>());
            if (level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
            helper(root.left, level + 1, res);
            helper(root.right, level + 1, res);
            return;
        }
    }
}

package src.com.Java;

import java.util.ArrayList;
import java.util.List;

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

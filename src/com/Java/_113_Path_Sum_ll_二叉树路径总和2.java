package src.com.Java;

import java.util.ArrayList;
import java.util.List;

public class _113_Path_Sum_ll_二叉树路径总和2 {
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
        private List<List<Integer>> res;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            res = new ArrayList<>();
            if (root == null)
                return res;
            List<Integer> path = new ArrayList<Integer>();
            help(root, sum, path);
            return res;
        }

        public void help(TreeNode r, int sum, List<Integer> path) {
            if (r == null)
                return;
            int val = sum - r.val;
            path.add(r.val);
            if (r.left == null && r.right == null && val == 0) {
                res.add(new ArrayList<Integer>(path));
            }
            help(r.left, val, path);
            help(r.right, val, path);
            path.remove(path.size() - 1);
        }
    }
}

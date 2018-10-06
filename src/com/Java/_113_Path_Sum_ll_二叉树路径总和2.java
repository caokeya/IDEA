package src.com.Java;

import java.util.ArrayList;
import java.util.List;
/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
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

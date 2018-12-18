package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
输入:
   1
 /   \
2     3
 \
  5
输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
*/
public class _257_Binary_Tree_Paths_二叉树的所有路径 {
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root != null) {
                if (root.left != null || root.right != null) {
                    helper(root.left, result, "" + root.val);
                    helper(root.right, result, "" + root.val);
                } else {
                    result.add(root.val + "");
                }
            }
            return result;
        }

        private void helper(TreeNode current, List<String> res, String path) {
            if (current != null) {
                String scurrent = path + "->" + current.val;
                if (current.left != null) {
                    helper(current.left, res, scurrent);
                }
                if (current.right != null) {
                    helper(current.right, res, scurrent);
                }
                if (current.left == null && current.right == null) {
                    res.add(scurrent);
                }
            }
        }
    }

    class Solution2 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<String>();
            if (root == null) return res;
            if (root.left == null && root.right == null) {
                res.add(String.valueOf(root.val));
                return res;
            }
            List<String> left = binaryTreePaths(root.left);
            List<String> right = binaryTreePaths(root.right);
            for (String str : left) {
                res.add(root.val + "->" + str);
            }
            for (String str : right) {
                res.add(root.val + "->" + str);
            }
            return res;
        }
    }
}

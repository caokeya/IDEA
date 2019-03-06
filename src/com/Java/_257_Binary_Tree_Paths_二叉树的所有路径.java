package src.src.com.Java;

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
    /*
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
            List<String> list = new ArrayList<>();
            if (root == null) return list;
            if (root.left == null && root.right == null) {
                list.add(String.valueOf(root.val));
            }
            if (root.right != null) {
                addVal(binaryTreePaths(root.right), root.val, list);
            }
            if (root.left != null) {
                addVal(binaryTreePaths(root.left), root.val, list);
            }
            return list;
        }

        public void addVal(List<String> ll, int val, List<String> list) {
            for (String s : ll) {
                list.add(String.valueOf(val) + "->" + s);
            }
        }
    }

    class Solution2 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) return res;
            helper(res, "", root);
            return res;
        }

        public void helper(List<String> res, String s, TreeNode root) {
            if (root.left == null && root.right == null) {
                res.add(s + root.val);
            }
            if (root.left != null)
                helper(res, s + root.val + "->", root.left);
            if (root.right != null)
                helper(res, s + root.val + "->", root.right);
        }
    }
}

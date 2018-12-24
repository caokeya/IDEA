package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树，返回它的 前序 遍历。
 示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,2,3]
 */
public class _144_Binary_Tree_Preorder_Traversal_二叉树前序遍历 {
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

    // recursive
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> pre = new LinkedList<Integer>();
            if (root == null)
                return pre;
            pre.add(root.val);
            pre.addAll(preorderTraversal(root.left));
            pre.addAll(preorderTraversal(root.right));
            return pre;
        }
    }

    // iterative
    public class SolutionStack {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null) return result;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
            return result;
        }
    }
}

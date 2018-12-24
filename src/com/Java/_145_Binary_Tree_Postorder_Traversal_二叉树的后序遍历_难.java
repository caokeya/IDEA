package src.com.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树，返回它的 后序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [3,2,1]
 */
public class _145_Binary_Tree_Postorder_Traversal_二叉树的后序遍历_难 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            helper(root, res);
            return res;
        }

        public void helper(TreeNode root, List<Integer> res) {
            if (root == null)
                return;
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }

    // iterative
    class SolutionStack {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root == null)
                return list;
            stack.push(root);
            while (!stack.empty()) {
                TreeNode treeNode = stack.peek();
                list.add(0, treeNode.val);
                stack.pop();
                if (treeNode.left != null)
                    stack.push(treeNode.left);
                if (treeNode.right != null)
                    stack.push(treeNode.right);
            }
            return list;
        }
    }
}

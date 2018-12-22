package src.com.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,3,2]
 */
public class _094_Binary_Tree_Inorder_Traversal_二叉树中序遍历 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }

    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            return res;
        }
    }
}

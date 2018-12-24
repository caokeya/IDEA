package src.com.Java;

import java.util.Stack;

/*
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
调用 next() 将返回二叉搜索树中的下一个最小的数。
注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 */
public class _173_Binary_Search_Tree_Iterator_二叉搜索树迭代器 {
    /*
     * Definition for binary tree
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                TreeNode right = node.right;
                while (right != null) {
                    stack.push(right);
                    right = right.left;
                }
            }
            return node.val;
        }
    }

    /**
     * Your BSTIterator will be called like this: 
     * BSTIterator i = newBSTIterator(root); 
     * while (i.hasNext()) v[f()] = i.next();
     */
}

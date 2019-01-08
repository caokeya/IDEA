package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
您需要在二叉树的每一行中找到最大的值。
示例：
输入: 
          1
         / \
        3   2
       / \   \  
      5   3   9 
输出: [1, 3, 9]
 */
public class _515_Find_Largest_Value_in_Each_Tree_Row_在每个树行中找最大值 {
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList();
            helper(res, 0, root);
            return res;
        }


        private void helper(List<Integer> res, int level, TreeNode node) {
            if (node == null)
                return;
            if (res.size() == level)
                res.add(node.val);
            if (node.val > res.get(level))
                res.set(level, node.val);
            helper(res, level + 1, node.left);
            helper(res, level + 1, node.right);
        }
    }

    class SolutionBFS {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    max = Math.max(max, node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(max);
            }
            return result;
        }
    }
}

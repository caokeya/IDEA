package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_Binary_Tree_Level_Order_Traversal_II_二叉树的层次遍历2 {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (root == null)
                return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                result.add(0, list);
            }
            return result;

        }
    }
}

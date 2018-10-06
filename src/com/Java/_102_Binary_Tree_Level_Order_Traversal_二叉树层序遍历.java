package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 */
public class _102_Binary_Tree_Level_Order_Traversal_二叉树层序遍历 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {

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
                result.add(list);
            }
            return result;

        }
    }
}

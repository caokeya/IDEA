package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
示例 1:
输入:
    3
   / \
  9  20
    /  \
   15   7
输出: [3, 14.5, 11]
解释:
第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 */
public class _637_Average_of_Levels_in_Binary_Tree_二叉树的层平均值 {
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();

            if (root == null)
                return result;
            q.add(root);
            while (!q.isEmpty()) {
                int n = q.size();
                double sum = 0.0;
                for (int i = 0; i < n; i++) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null)
                        q.offer(node.left);
                    if (node.right != null)
                        q.offer(node.right);
                }
                result.add(sum / n);
            }
            return result;
        }
    }
}

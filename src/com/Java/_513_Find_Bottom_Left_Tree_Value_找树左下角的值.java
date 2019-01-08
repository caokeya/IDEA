package src.com.Java;

import java.util.LinkedList;
import java.util.Queue;

/*
给定一个二叉树，在树的最后一行找到最左边的值。
示例 1:
输入:
    2
   / \
  1   3
输出:
1
示例 2:
输入:
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
输出:
7
 */
public class _513_Find_Bottom_Left_Tree_Value_找树左下角的值 {
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
        public int findBottomLeftValue(TreeNode root) {
            int[] record = new int[2];
            dfs(root, 1, record);
            return record[1];
        }

        private void dfs(TreeNode root, int depth, int[] record) {
            if (root == null) {
                return;
            }

            if (depth > record[0]) {
                record[0] = depth;
                record[1] = root.val;
            }
            depth++;
            dfs(root.left, depth, record);
            dfs(root.right, depth, record);
        }
    }

    class Solution2 {
        /*
        典型的BFS，每一层加入queue，每一层的第一个即是leftmostnode
         */
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int res = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    if (i == 0)
                        res = node.val;

                    if (node.left != null)
                        queue.offer(node.left);

                    if (node.right != null)
                        queue.offer(node.right);
                }
            }
            return res;
        }
    }
}

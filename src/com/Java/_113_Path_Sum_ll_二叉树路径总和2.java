package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class _113_Path_Sum_ll_二叉树路径总和2 {
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null)
                return list;
            checkPath(root, sum, list, new ArrayList<>());
            return list;
        }

        public void checkPath(TreeNode root, int sum, List<List<Integer>> list, List<Integer> cur) {
            if (root == null)
                return;
            cur.add(root.val);
            if (root.left == null && root.right == null && sum - root.val == 0)
                list.add(new ArrayList<>(cur));

            checkPath(root.left, sum - root.val, list, cur);
            checkPath(root.right, sum - root.val, list, cur);
            cur.remove(cur.size() - 1);
        }
    }
}

package com.Java;

import java.util.ArrayList;
import java.util.List;

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

    public class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            helper(root, res, 0);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res, int d) {
            if (root == null) {
                return;
            }
            // expand list size
            if (d == res.size()) {
                res.add(root.val);
            } else {
                // or set value
                res.set(d, Math.max(res.get(d), root.val));
            }
            helper(root.left, res, d + 1);
            helper(root.right, res, d + 1);
        }
    }
}

package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
案例 1:
输入: 
    5
   / \
  3   6
 / \   \
2   4   7
Target = 9
输出: True
案例 2:
输入: 
    5
   / \
  3   6
 / \   \
2   4   7
Target = 28
输出: False
 */
public class _653_Two_Sum_IV_Input_is_a_BST两数之和4输入BST {
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
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<Integer>();
            return find(root, set, k);
        }

        public boolean find(TreeNode root, Set<Integer> set, int k) {
            if (root == null)
                return false;

            if (set.contains(k - root.val))
                return true;
            set.add(root.val);

            return find(root.left, set, k) || find(root.right, set, k);

        }
    }
}

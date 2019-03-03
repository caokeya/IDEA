package com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
示例 1:
输入: 
           1
         /   \
        3     2
       / \     \  
      5   3     9 
输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
示例 2:
输入: 
          1
         /  
        3    
       / \       
      5   3     
输出: 2
解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 */
public class _662_Maximum_Width_of_Binary_Tree_二叉树最大宽度 {
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
        public int widthOfBinaryTree(TreeNode root) {
            return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
        }

        public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
            if (root == null)
                return 0;
            if (start.size() == level) {
                start.add(order);
                end.add(order);
            } else
                end.set(level, order);
            int cur = end.get(level) - start.get(level) + 1;
            int left = dfs(root.left, level + 1, 2 * order, start, end);
            int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
            return Math.max(cur, Math.max(left, right));
        }
    }
}

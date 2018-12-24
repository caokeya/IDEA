package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例:
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class _199_Binary_Tree_Right_Side_View_二叉树的右视图 {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res, 0);
            return res;
        }

        private void dfs(TreeNode node, List<Integer> list, int d) {
            if(node == null)
                return;
            if(list.size() > d) {
                list.set(d, node.val);
            } else {
                list.add(node.val);
            }
            dfs(node.left, list, d + 1);
            dfs(node.right, list, d + 1);
        }
    }
}

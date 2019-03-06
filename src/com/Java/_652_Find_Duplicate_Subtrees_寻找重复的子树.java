package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
两棵树重复是指它们具有相同的结构以及相同的结点值。
示例 1：
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
下面是两个重复的子树：
      2
     /
    4
和
    4
 */
public class _652_Find_Duplicate_Subtrees_寻找重复的子树 {
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
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            helper(res, root, map);
            return res;
        }

        public String helper(List<TreeNode> res, TreeNode root, HashMap<String, Integer> map) {
            if (root == null)
                return " ";
            String s = root.val + helper(res, root.left, map) + helper(res, root.right, map);
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) == 2)
                res.add(root);
            return s;
        }
    }
}

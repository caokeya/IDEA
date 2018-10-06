package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
假定 BST 有如下定义：
    结点左子树中所含结点的值小于等于当前结点的值
    结点右子树中所含结点的值大于等于当前结点的值
    左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],
   1
    \
     2
    /
   2
返回[2].
提示：如果众数超过1个，不需考虑输出顺序
 */
public class _501_Find_Mode_in_Binary_Search_Tree_二叉搜索树中的众数 {
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
        Map<Integer, Integer> map;
        int max = 0;

        public int[] findMode(TreeNode root) {
            if (root == null)
                return new int[0];
            this.map = new HashMap<>();

            inorder(root);

            List<Integer> list = new LinkedList<>();
            for (int key : map.keySet()) {
                if (map.get(key) == max)
                    list.add(key);
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++)
                res[i] = list.get(i);
            return res;
        }

        private void inorder(TreeNode node) {
            if (node.left != null)
                inorder(node.left);
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            max = Math.max(max, map.get(node.val));
            if (node.right != null)
                inorder(node.right);
        }
    }
    
    class Solution2 {
        private Map<Integer, Integer> map = new HashMap<>();
        private ArrayList<Integer> result = new ArrayList<>();
        private int max = 0;
        public int[] findMode(TreeNode root) {
            if (root == null) return new int[0];
            dfs(root);
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }
        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            int count = map.getOrDefault(node.val, 0) + 1;
            map.put(node.val, count);
            if (max < count + 1) {
                max = count + 1;
                result = new ArrayList<>();
                result.add(node.val);
            } else if (max == count + 1) {
                result.add(node.val);
            }
            
            dfs(node.right);
        }
    }
}

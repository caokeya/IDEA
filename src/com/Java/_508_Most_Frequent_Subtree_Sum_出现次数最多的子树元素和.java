package com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
示例 1
输入:
  5
 /  \
2   -3
返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
示例 2
输入:
  5
 /  \
2   -5
返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 */
public class _508_Most_Frequent_Subtree_Sum_出现次数最多的子树元素和 {
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
        public int[] findFrequentTreeSum(TreeNode root) {

            Map<Integer, Integer> map = new HashMap<>();
            getSum(root, map);

            int max_count = 0;
            Set<Integer> set = new HashSet<>();

            for (int k : map.keySet()) {
                if (map.get(k) == max_count)
                    set.add(k);
                else if (map.get(k) > max_count) {
                    set.clear();
                    set.add(k);
                    max_count = map.get(k);
                }
            }

            int[] res = new int[set.size()];
            int idx = 0;
            for (int i : set)
                res[idx++] = i;

            return res;
        }

        private int getSum(TreeNode node, Map<Integer, Integer> map) {
            if (node == null)
                return 0;

            int sum = node.val + getSum(node.left, map) + getSum(node.right, map);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return sum;
        }
    }
}

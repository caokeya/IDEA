package com.Java;

import java.util.List;

/*
给定一个N叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
例如，给定一个 3叉树 :
                    1
                 3  2  4
               5  6
我们应返回其最大深度，3。
 */
public class _559_Maximum_Depth_of_N_ary_Tree_N叉树的最大深度 {
    /*
     * Definition for a Node.
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        public int maxDepth(Node root) {
            if (root == null)
                return 0;

            int max = 0;
            for (Node c : root.children) {
                max = Math.max(max, maxDepth(c));
            }
            return max + 1;
        }
    }
}

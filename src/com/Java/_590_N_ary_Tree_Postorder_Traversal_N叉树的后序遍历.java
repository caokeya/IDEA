package com.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
给定一个N叉树，返回其节点值的后序遍历。
例如，给定一个 3叉树 :
                1
             3  2  4
            5  6
返回其后序遍历: [5,6,3,2,4,1].
 */
public class _590_N_ary_Tree_Postorder_Traversal_N叉树的后序遍历 {
    /*
     * // Definition for a Node.
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

    // Iterative Solution
    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null)
                return list;

            Stack<Node> stack = new Stack<>();
            stack.add(root);

            while (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                for (Node node : root.children)//三叉树中，同一层中的存储顺序是反向的：3  2  4--> 4 2 3
                    stack.add(node);
            }
            Collections.reverse(list);
            return list;
        }
    }

    // Recursive Solution
    class Solution2 {
        List<Integer> list = new ArrayList<>();

        public List<Integer> postorder(Node root) {
            if (root == null)
                return list;

            for (Node child : root.children)
                postorder(child);

            list.add(root.val);

            return list;
        }
    }
}

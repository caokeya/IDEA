package com.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个N叉树，返回其节点值的前序遍历。
例如，给定一个 3叉树 :
                1
             3  2  4
           5  6
返回其前序遍历: [1,3,5,6,2,4]。
 */
public class _589_N_ary_Tree_Preorder_Traversal_N叉树的前序遍历 {

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
    class Solution2 {
        public List<Integer> preorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null)
                return list;

            Stack<Node> stack = new Stack<>();
            stack.add(root);

            while (!stack.empty()) {
                root = stack.pop();
                list.add(root.val);
                for (int i = root.children.size() - 1; i >= 0; i--)//N叉树中，同一层中的存储顺序是反向的：3  2  4--> 4 2 3
                    stack.add(root.children.get(i));
            }

            return list;
        }
    }

    // Recursive Solution
    class Solution {
        public List<Integer> list = new ArrayList<>();

        public List<Integer> preorder(Node root) {
            if (root == null)
                return list;

            list.add(root.val);
            for (Node node : root.children)
                preorder(node);

            return list;
        }
    }

}

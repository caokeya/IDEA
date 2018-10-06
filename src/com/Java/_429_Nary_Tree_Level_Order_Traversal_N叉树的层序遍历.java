package src.com.Java;

import java.util.LinkedList;
import java.util.List;

/*
给定一个N叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
返回其层序遍历:
[
     [  1  ],
     [3,2,4],
    [5,6]
]
 */
public class _429_Nary_Tree_Level_Order_Traversal_N叉树的层序遍历 {
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
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new LinkedList<>();
            return traverse(root, ans, 0);
        }

        private List<List<Integer>> traverse(Node node, List<List<Integer>> ans, int level) {
            if (node == null)
                return ans;
            List<Integer> list = ans.size() > level ? ans.get(level) : new LinkedList();
            list.add(node.val);
            if (ans.size() <= level)
                ans.add(list);
            for (Node n : node.children)
                traverse(n, ans, level + 1);
            return ans;
        }
    }
}

package src.com.Java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
完全二叉树是每一层（除最后一层外）都是完全填充（即，结点数达到最大）的，并且所有的结点都尽可能地集中在左侧。
设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
    CBTInserter(TreeNode root) 使用头结点为 root 的给定树初始化该数据结构；
    CBTInserter.insert(int v) 将 TreeNode 插入到存在值为 node.val = v  的树中以使其保持完全二叉树的状态，并返回插入的 TreeNode 的父结点的值；
    CBTInserter.get_root() 将返回树的头结点。
示例 1：
输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
输出：[null,1,[1,2]]
示例 2：
输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 */
public class _919_Complete_Binary_Tree_Inserter_完全二叉树插入器 {
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

    class CBTInserter {

        List<TreeNode> tree;

        public CBTInserter(TreeNode root) {
            tree = new ArrayList<>();
            tree.add(root);
            for (int i = 0; i < tree.size(); ++i) {
                if (tree.get(i).left != null)
                    tree.add(tree.get(i).left);
                if (tree.get(i).right != null)
                    tree.add(tree.get(i).right);
            }
        }

        public int insert(int v) {
            int N = tree.size();
            TreeNode node = new TreeNode(v);
            tree.add(node);
            if (N % 2 == 1)
                tree.get((N - 1) / 2).left = node;
            else
                tree.get((N - 1) / 2).right = node;
            return tree.get((N - 1) / 2).val;
        }

        public TreeNode get_root() {
            return tree.get(0);
        }
    }
    
    class CBTInserter2 {
        TreeNode root;
        Deque<TreeNode> deque;
        public CBTInserter2(TreeNode root) {
            this.root = root;
            deque = new LinkedList<TreeNode>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            // BFS to populate deque
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left == null || node.right == null)
                    deque.offerLast(node);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        public int insert(int v) {
            TreeNode node = deque.peekFirst();
            deque.offerLast(new TreeNode(v));
            if (node.left == null)
                node.left = deque.peekLast();
            else {
                node.right = deque.peekLast();
                deque.pollFirst();
            }

            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
    /**
     * Your CBTInserter object will be instantiated and called as such:
     * CBTInserter obj = new CBTInserter(root);
     * int param_1 = obj.insert(v);
     * TreeNode param_2 = obj.get_root();
     */
}

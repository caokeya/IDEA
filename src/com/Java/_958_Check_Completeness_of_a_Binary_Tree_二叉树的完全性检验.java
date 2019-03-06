package src.com.Java;

import java.util.LinkedList;
import java.util.Queue;

/*
给定一个二叉树，确定它是否是一个完全二叉树。
若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
示例 1：
输入：[1,2,3,4,5,6]
输出：true
解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
示例 2：
输入：[1,2,3,4,5,null,7]
输出：false
解释:值为 7 的结点没有尽可能靠向左侧。
 */
public class _958_Check_Completeness_of_a_Binary_Tree_二叉树的完全性检验 {
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
        public boolean isCompleteTree(TreeNode root) {
            boolean end = false;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if(cur == null) end = true;
                else{
                    if(end) return false;
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            return true;
        }
    }
    class Solution2 {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> quque = new LinkedList<TreeNode>();
            quque.add(root);
            while (quque.peek() != null) {
                TreeNode node = quque.poll();
                quque.add(node.left);
                quque.add(node.right);
            }
            while (!quque.isEmpty() && quque.peek() == null)
                quque.poll();
            return quque.isEmpty();
        }
    }
}

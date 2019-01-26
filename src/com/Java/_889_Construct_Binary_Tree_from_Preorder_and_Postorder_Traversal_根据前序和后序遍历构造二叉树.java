package src.com.Java;

import java.util.ArrayDeque;
import java.util.Deque;

/*
返回与给定的前序和后序遍历匹配的任何二叉树。
 pre 和 post 遍历中的值是不同的正整数。
示例：
输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
输出：[1,2,3,4,5,6,7]
        1
    2       3
  4   5   6   7
preorder traversal is [1] + [2, 4, 5] + [3, 6, 7],
postorder traversal is [4, 5, 2] + [6, 7, 3] + [1].
 */
public class _889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal_根据前序和后序遍历构造二叉树 {
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
    /*
    循环预数组，逐个构造节点。
    堆栈保存树的当前路径。
    node = new TreeNode(pre[i])，如果不是左子节点，将节点添加到左边。否则把它加到右边。
    如果我们在pre和post中遇到相同的值，这意味着我们完成了当前子树的构造。我们从堆栈中取出它。
    */
    class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(new TreeNode(pre[0]));
            for (int i = 1, j = 0; i < pre.length; ++i) {
                TreeNode node = new TreeNode(pre[i]);
                while (deque.getLast().val == post[j]) {
                    deque.pollLast();
                    j++;
                }
                if (deque.getLast().left == null)
                    deque.getLast().left = node;
                else
                    deque.getLast().right = node;
                deque.offer(node);
            }
            return deque.getFirst();
        }
    }

    class Solution2 {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return buildTree(pre, post, 0, post.length - 1, new int[] { 0 });
        }

        TreeNode buildTree(int[] pre, int[] post, int left, int right, int[] index) {
            if (left > right)
                return null;
            index[0]++;
            TreeNode root = new TreeNode(post[right]);
            if (left == right)
                return root;
            int i = left;
            while (i <= right && post[i] != pre[index[0]])
                i++;
            root.left = buildTree(pre, post, left, i, index);
            root.right = buildTree(pre, post, i + 1, right - 1, index);
            return root;
        }
    }
}

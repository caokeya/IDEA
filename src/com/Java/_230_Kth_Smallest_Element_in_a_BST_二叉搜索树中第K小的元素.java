package src.src.com.Java;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 说明：
 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 示例 1:
 输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
 */
public class _230_Kth_Smallest_Element_in_a_BST_二叉搜索树中第K小的元素 {
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

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new LinkedList<>();
            helper(root, list);
            return list.get(k - 1);
        }

        private void helper(TreeNode root, List<Integer> list) {
            if (root == null) return;
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }

    class Solution2 {
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.empty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                k--;
                if (k == 0) {
                    break;
                }
                root = root.right;
            }
            return root.val;
        }
    }

    class Solution3 {
        public int kthSmallest(TreeNode root, int k) {
            int count = countN(root.left);
            if (count >= k)
                return kthSmallest(root.left, k);
            else if (count < k - 1) {
                return kthSmallest(root.right, k - count - 1);
            } else {
                return root.val;
            }
        }

        private int countN(TreeNode node) {
            if (node == null) return 0;
            return countN(node.left) + countN(node.right) + 1;
        }
    }
}

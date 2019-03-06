package src.com.Java;

/*
给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
示例 :
输入:
   1
    \
     3
    /
   2
输出:
1
解释:
最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class _530_Minimum_Absolute_Difference_in_BST_二叉搜索树的最小绝对差 {

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
        private int min = Integer.MAX_VALUE;
        private Integer prev = null;

        public int getMinimumDifference(TreeNode root) {
            if (root == null)
                return 0;
            getMinimumDifference(root.left);
            if (prev != null) {
                min = Math.min(min, root.val - prev);
            }
            prev = root.val;
            getMinimumDifference(root.right);
            return min;
        }
    }

}

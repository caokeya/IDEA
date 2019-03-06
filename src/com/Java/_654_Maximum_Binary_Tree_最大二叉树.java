package src.com.Java;

/*
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
    二叉树的根是数组中的最大元素。
    左子树是通过数组中最大值左边部分构造出的最大二叉树。
    右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。
Example 1:
输入: [3,2,1,6,0,5]
输入: 返回下面这棵树的根节点：
      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
 */
public class _654_Maximum_Binary_Tree_最大二叉树 {
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return buildTree(nums, 0, nums.length - 1);
        }

        private TreeNode buildTree(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            // find the max number's index in the range of left and right
            int max = left;
            for (int i = left; i <= right; i++) {
                if (nums[max] < nums[i]) {
                    max = i;
                }
            }

            TreeNode node = new TreeNode(nums[max]);
            node.left = buildTree(nums, left, max - 1);
            node.right = buildTree(nums, max + 1, right);
            return node;
        }
    }
}

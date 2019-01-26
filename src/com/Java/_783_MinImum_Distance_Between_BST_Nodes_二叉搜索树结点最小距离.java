package src.com.Java;

/*
给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
示例：
输入: root = [4,2,6,1,3,null,null]
输出: 1
解释:
注意，root是树结点对象(TreeNode object)，而不是数组。
给定的树 [4,2,6,1,3,null,null] 可表示为下图:
          4
        /   \
      2      6
     / \    
    1   3  
最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 */
public class _783_MinImum_Distance_Between_BST_Nodes_二叉搜索树结点最小距离 {
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
        //BST 中序遍历获得有序数组
        int prev = Integer.MIN_VALUE, res = Integer.MAX_VALUE;

        public int minDiffInBST(TreeNode root) {
            inorder(root);
            return res;
        }

        public void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            if (prev != Integer.MIN_VALUE) {
                res = Math.min(root.val - prev, res);
            }
            prev = root.val;
            inorder(root.right);
        }
    }
}

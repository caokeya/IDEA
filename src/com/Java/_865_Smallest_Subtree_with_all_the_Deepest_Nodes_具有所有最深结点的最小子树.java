package com.Java;

/*
给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
一个结点的子树是该结点加上它的所有后代的集合。
返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
示例：
输入：[3,5,1,6,2,0,8,null,null,7,4]
输出：[2,7,4]
解释：
我们返回值为 2 的结点，在图中用黄色标记。
输入 "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" 是对给定的树的序列化表述。
输出 "[2, 7, 4]" 是对根结点的值为 2 的子树的序列化表述。
输入和输出都具有 TreeNode 类型。
 */
public class _865_Smallest_Subtree_with_all_the_Deepest_Nodes_具有所有最深结点的最小子树 {
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
        public int depth(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root == null)
                return null;
            int left = depth(root.left);
            int right = depth(root.right);
            if (left == right)
                return root;
            if (left > right)
                return subtreeWithAllDeepest(root.left);
            return subtreeWithAllDeepest(root.right);
        }
    }

    // 先找root to leaf，找到每一个leaf的深度
    // 如果左最深和右最深均为最深深度（相等且等于deepestdepth），那么update node "res"
    // 如果左右两个字树返回的deepest相等，那么是一个local解，如果不等，那么这个root不是一个local解，
    //如果左右两边的deepest相等并且和global deepestDepth相等，那么是一个global解。
    // 每个Node返回给上面的值（返回currLevel）是最深的子树的level
    class Solution2 {
        private TreeNode res = null;
        private int deepestDepth = 0;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            dfs(root, 0);
            return res;
        }

        private int dfs(TreeNode root, int level) {
            if (root == null)
                return level;
            int deepestLeft = dfs(root.left, level + 1);
            int deepestRight = dfs(root.right, level + 1);
            int currLevel = Math.max(deepestLeft, deepestRight);
            deepestDepth = Math.max(deepestDepth, currLevel);
            if (deepestLeft == deepestDepth && deepestRight == deepestDepth)
                res = root;
            return currLevel;
        }
    }
}

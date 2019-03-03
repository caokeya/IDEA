package com.Java;

import java.util.HashMap;
import java.util.Map;
/*
根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_从前序和中序遍历序列构造二叉树 {
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
        int preIndex = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return constructTree(preorder, 0, inorder.length);
        }
        /*
        pre: 3 9 20 15 7
        in : 9 3 15 20 7
                        3
                    9      20
                         15   7
        */
        public TreeNode constructTree(int[] preorder, int start, int end) {
            if (start > end || preIndex > preorder.length - 1)
                return null;
            int rootVal = preorder[preIndex++];
            TreeNode root = new TreeNode(rootVal);
            int rootIndex = indexMap.get(rootVal);
            root.left = constructTree(preorder, start, rootIndex - 1);
            root.right = constructTree(preorder, rootIndex + 1, end);

            return root;
        }
    }
}

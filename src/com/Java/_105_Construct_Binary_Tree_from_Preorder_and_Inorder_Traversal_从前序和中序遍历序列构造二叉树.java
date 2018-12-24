package src.com.Java;

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
        int preorderIndex;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderIndex = 0;
            Map<Integer, Integer> inorderIndex = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndex.put(inorder[i], i);
            }
            return build(preorder, inorder, inorderIndex, 0, inorder.length - 1);
        }

        /*
        pre: 3 9 20 15 7
        in : 9 3 15 20 7
                3
            9      20
                 15   7
        */
        public TreeNode build(int[] preorder, int[] inorder, Map<Integer, Integer> inorderIndex, int iStart, int iEnd) {
            if (preorderIndex >= inorder.length || iStart > iEnd || iStart >= inorder.length || iEnd < 0) return null;
            int rootval = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootval);

            int inorderMid = inorderIndex.get(rootval);
            root.left = build(preorder, inorder, inorderIndex, iStart, inorderMid - 1);
            root.right = build(preorder, inorder, inorderIndex, inorderMid + 1, iEnd);
            return root;
        }
    }


}

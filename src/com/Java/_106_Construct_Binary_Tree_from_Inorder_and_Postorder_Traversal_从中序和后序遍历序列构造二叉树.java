package src.src.com.Java;

import java.util.HashMap;

/*
根据一棵树的中序遍历与后序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
 */
public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_从中序和后序遍历序列构造二叉树 {
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
        int postIndex = 0;
        HashMap<Integer, Integer> map;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (postorder == null || postorder.length == 0)
                return null;
            postIndex = postorder.length - 1;
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(inorder, postorder, 0, inorder.length - 1);

        }

        /*
        in  : 9 3 15 20 7
        post: 9 15 7 20 3
                    3
                9      20
                     15   7
        */
        public TreeNode buildTree(int[] inorder, int[] postorder, int inS, int inE) {
            if (inS > inE)
                return null;
            TreeNode node = new TreeNode(postorder[postIndex--]);
            if (inS == inE)
                return node;
            int index = map.get(node.val);
            node.right = buildTree(inorder, postorder, index + 1, inE);
            node.left = buildTree(inorder, postorder, inS, index - 1);
            return node;
        }
    }
}

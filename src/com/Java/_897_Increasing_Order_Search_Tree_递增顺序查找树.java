package src.com.Java;

/*
给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
示例 ：
输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9
输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
 */
public class _897_Increasing_Order_Search_Tree_递增顺序查找树 {
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
        public TreeNode increasingBST(TreeNode root) {
            return helper(root, null);
        }

        public TreeNode helper(TreeNode root, TreeNode tail) {
            if (root == null)
                return tail;
            TreeNode res = helper(root.left, root);
            root.left = null;
            root.right = helper(root.right, tail);
            return res;
        }
    }
}

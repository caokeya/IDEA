package src.com.Java;

/*
给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
示例 1:
输入: 
二叉树如下所示:
       4
     /   \
    2     6
   / \   / 
  3   1 5   
v = 1
d = 2
输出: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   
示例 2:
输入: 
二叉树如下所示:
      4
     /   
    2    
   / \   
  3   1    
v = 1
d = 3
输出: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
 */
public class _623_Add_One_Row_to_Tree_在二叉树中增加一行 {
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
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 0 || d == 1) {
                TreeNode newroot = new TreeNode(v);
                newroot.left = d == 1 ? root : null;
                newroot.right = d == 0 ? root : null;
                return newroot;
            }
            if (root != null && d >= 2) {
                root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
                root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
            }
            return root;
        }
    }


    class Solution2 {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode newroot = new TreeNode(v);
                newroot.left = root;
                return newroot;
            }
            dfs(root, 1, v, d);
            return root;
        }

        private void dfs(TreeNode root, int depth, int v, int d) {
            if (root == null) return;
            if (depth < d - 1) {
                dfs(root.left, depth + 1, v, d);
                dfs(root.right, depth + 1, v, d);
            } else {
                TreeNode tmp = root.left;
                root.left = new TreeNode(v);
                root.left.left = tmp;
                tmp = root.right;
                root.right = new TreeNode(v);
                root.right.right = tmp;
            }
        }

    }
}

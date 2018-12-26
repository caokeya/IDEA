package src.com.Java;

/*给出一个完全二叉树，求出该树的节点个数。
说明：
完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
示例:
输入:
    1
   / \
  2   3
 / \  /
4  5 6
输出: 6
*/
public class _222_Count_Complete_Tree_Nodes_完全二叉树的节点个数 {
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
        int res = 0;

        public int countNodes(TreeNode root) {
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null)
                return;
            if (root.val < 0)
                return;
            root.val = -1;
            res++;
            dfs(root.left);
            dfs(root.right);
        }
    }

    class Solution2 {
        public int countNodes(TreeNode root) {
            // assumption: left & right can't be complete both
            // case 1 : left height == right height => left is perfect tree
            // case 2 : left height = right height + 1 => right is perfect tree
            if (root == null)
                return 0;
            int ans = 0;
            while(root != null) {
                int left = getHeight(root.left);
                int right = getHeight(root.right);
                if (left == right) {
                    // case 1 left is perfect tree
                    ans += 1 << left;
                    root = root.right;
                } else {
                    //case 2 right is perfect tree
                    ans += 1 << right;
                    root = root.left;
                }
            }
            return ans;
        }

        private int getHeight(TreeNode root) {
            int height = 0;
            while(root != null) {
                root = root.left;
                height++;
            }
            return height;
        }
    }
}

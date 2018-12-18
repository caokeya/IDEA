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
        public int countNodes(TreeNode root) {
            if (root == null) return 0;

            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            // same height means missing node in right-subtree
            if (leftHeight == rightHeight)
                return (1 << leftHeight) + countNodes(root.right);
            else // different height means missing node in left-subtree
                return (1 << rightHeight) + countNodes(root.left);
        }

        private int getHeight(TreeNode node) {
            int height = 0;

            // 只用求从根节点到最左端节点的长度
            while (node != null) {
                node = node.left;
                height++;
            }

            return height;
        }
    }

    class Solution2 {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.val != Integer.MAX_VALUE) {
                root.val = Integer.MAX_VALUE;
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
            return 0;
        }
    }

}

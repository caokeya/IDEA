package src.com.Java;

/*
我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
示例：
输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
输出：true
 */
public class _951_Flip_Equivalent_Binary_Trees_翻转等价二叉树 {
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
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == root2)
                return true;
            if (root1 == null || root2 == null || root1.val != root2.val)
                return false;
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                    || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        }
    }
}

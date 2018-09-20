package src.com.Java;

public class _116_Populating_Next_Right_Pointers_in_Each_Node_填充同一层的兄弟节点 {
    /**
     * Definition for binary tree with next pointer.
     */
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
    //设定为完美二叉树
    public class Solution {
        public void connect(TreeLinkNode root) {
            TreeLinkNode head = root;
            while (head != null) {
                TreeLinkNode cur = head;
                while (cur != null) {
                    if (cur.left != null)
                        cur.left.next = cur.right;
                    if (cur.right != null && cur.next != null)
                        cur.right.next = cur.next.left;

                    cur = cur.next;
                }
                head = head.left;
            }
        }
    }
}

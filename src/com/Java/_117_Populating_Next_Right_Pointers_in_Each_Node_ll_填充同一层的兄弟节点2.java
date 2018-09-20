package src.com.Java;

public class _117_Populating_Next_Right_Pointers_in_Each_Node_ll_填充同一层的兄弟节点2 {
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

    // 设定为非完美二叉树
    public class Solution {
        public void connect(TreeLinkNode root) {

            while (root != null) {
                TreeLinkNode tempChild = new TreeLinkNode(0);
                TreeLinkNode currentChild = tempChild;
                while (root != null) {
                    if (root.left != null) {
                        currentChild.next = root.left;
                        currentChild = currentChild.next;
                    }
                    if (root.right != null) {
                        currentChild.next = root.right;
                        currentChild = currentChild.next;
                    }
                    root = root.next;
                }
                root = tempChild.next;
            }
        }
    }

}

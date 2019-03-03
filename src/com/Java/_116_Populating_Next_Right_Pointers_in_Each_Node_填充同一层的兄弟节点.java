package com.Java;
/*
给定一个二叉树
struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
示例:
给定完美二叉树，
     1
   /  \
  2    3
 / \  / \
4  5  6  7
调用你的函数后，该完美二叉树变为：
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
 */
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

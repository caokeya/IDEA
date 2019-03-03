package com.Java;
/*
给定一个二叉树
struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）
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

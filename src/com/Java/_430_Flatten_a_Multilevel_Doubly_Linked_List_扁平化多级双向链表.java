package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
示例:
输入:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
输出:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class _430_Flatten_a_Multilevel_Doubly_Linked_List_扁平化多级双向链表 {
    /*
     * // Definition for a Node.
     */

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    class Solution {
        public Node flatten(Node head) {
            Node cur = head;
            while (cur != null) {
                if (cur.child == null) {
                    cur = cur.next;
                } else {
                    Node child = cur.child;
                    while (child.next != null) {// 存在子节点则进入子节点
                        child = child.next;
                    }
                    child.next = cur.next;
                    if (cur.next != null) {// 已经是结尾，将最后节点的前置节点设为child
                        cur.next.prev = child;
                    }
                    cur.next = cur.child;
                    cur.child.prev = cur;
                    cur.child = null;
                }
            }
            return head;
        }
    }

    class Solution2 {
        /*
        Global variable pre to track the last node we visited
        */
        Node pre = null;

        public Node flatten(Node head) {
            if (head == null) {
                return null;
            }
            /*
            Connect last visted node with current node
            */
            if (pre != null) {
                pre.next = head;
                head.prev = pre;
            }

            pre = head;
            /*
            Store head.next in a next pointer in case recursive call to flatten head.child overrides head.next
            */
            Node next = head.next;

            flatten(head.child);
            head.child = null;

            flatten(next);
            return head;
        }
    }
}

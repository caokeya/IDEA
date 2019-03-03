package com.Java;

/*
编写一个程序，找到两个单链表相交的起始节点。
例如，下面的两个链表：
A:      a1 → a2
                                               ↘
                 c1 → c2 → c3
                                               ↗            
B: b1 → b2 → b3
在节点 c1 开始相交。
注意：
    如果两个链表没有交点，返回 null.
    在返回结果后，两个链表仍须保持原有的结构。
    可假定整个链表结构中没有循环。
    程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class _160_Intersection_of_Two_Linked_Lists_相交链表 {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // boundary check
            if (headA == null || headB == null)
                return null;

            ListNode a = headA;
            ListNode b = headB;

            // if a & b have different len, then we will stop the loop after second iteration
            while (a != b) {
                // for the end of first iteration, we just reset the pointer to the head of another linkedlist
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }

            return a;
        }
    }
}

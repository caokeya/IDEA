package com.Java;

public class _147_Insertion_Sort_List_链表插入排序 {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        /*
         * T(n): O(n^2) S(n): O(1)
         */
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.next.val >= curr.val) {
                    curr = curr.next;
                } else {
                    ListNode tmp = curr.next;
                    curr.next = tmp.next;
                    ListNode prev = dummy;
                    while (tmp.val >= prev.next.val) {
                        prev = prev.next;
                    }
                    tmp.next = prev.next;
                    prev.next = tmp;
                }
            }
            return dummy.next;
        }
    }
}

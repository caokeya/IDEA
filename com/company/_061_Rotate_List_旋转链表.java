package com.company;

public class _061_Rotate_List_旋转链表 {
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null)
                return null;
            ListNode cur = head;
            int len = 1;
            while (cur.next != null) {
                cur = cur.next;
                len++;
            }
            cur.next = head;
            for (int i = 1; i < len - k % len; i++) {
                head = head.next;
            }
            ListNode res = head.next;
            head.next = null;

            return res;
        }
    }
}

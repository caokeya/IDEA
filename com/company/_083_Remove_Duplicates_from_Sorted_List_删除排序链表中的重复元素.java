package com.company;

public class _083_Remove_Duplicates_from_Sorted_List_删除排序链表中的重复元素 {
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            head.next = deleteDuplicates(head.next);
            return head.val == head.next.val ? head.next : head;
        }
    }
}

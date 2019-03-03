package com.Java;

/*
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class _148_Sort_List_链表归并排序 {

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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode mid = getMidListNode(head);
            ListNode list2 = mid.next;
            mid.next = null;
            return mergeList(sortList(head), sortList(list2));
        }

        private ListNode mergeList(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }
            curr.next = list1 != null ? list1 : list2;
            return dummyHead.next;
        }

        private ListNode getMidListNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;

            }
            return slow;
        }

    }
}

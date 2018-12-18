package src.com.Java;

/*
反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/

public class _206_Reverse_Linked_List_反转链表 {
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
        public ListNode reverseList(ListNode head) {
            ListNode first = head;
            ListNode reserveHead = null;

            while (first != null) {
                ListNode second = first.next;
                first.next = reserveHead;
                reserveHead = first;
                first = second;
            }
            return reserveHead;
        }
    }
}

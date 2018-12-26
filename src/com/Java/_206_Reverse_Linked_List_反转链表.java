package src.com.Java;

/*
反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/

import java.util.Set;

public class _206_Reverse_Linked_List_反转链表 {
    /*
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
            /*For example; if we have a list [1, 2, 3, 4], the algorithm will do the following:
            Set pivot to 1, set frontier to 2, keep head at 1
            We see that pivot still has items after it, so set pivots .next to .next.next, and move the pivot to be set to the current head
            Now move the head back to point to the new head, which is the frontier node we just set
            Now reset frontier to pivots .next and repeat.

            So with each iteration of the loop the list becomes:
                [1, 2, 3, 4]
                [2, 1, 3, 4]
                [3, 2, 1, 4]
                [4, 3, 2, 1]
            */
            if (head != null && head.next != null) {
                ListNode pivot = head;
                ListNode frontier = null;
                while (pivot != null && pivot.next != null) {
                    frontier = pivot.next;
                    pivot.next = pivot.next.next;
                    frontier.next = head;
                    head = frontier;
                }
            }
            return head;
        }
    }

    public class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return head;
            ListNode next = head.next;
            head.next = null;
            return recursive(head, next);
        }

        private ListNode recursive(ListNode head, ListNode next) {
            if (next == null) return head;
            ListNode temp = next.next;
            next.next = head;
            return recursive(next, temp);
        }
    }
}

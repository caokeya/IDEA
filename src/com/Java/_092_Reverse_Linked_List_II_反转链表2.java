package src.com.Java;

public class _092_Reverse_Linked_List_II_反转链表2 {
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            int count = 0;
            ListNode curr = dummy;
            ListNode pre = null;
            while (curr != null && count < m) {
                pre = curr;
                curr = curr.next;
                count += 1;
            }

            while (count < n) {
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
                count += 1;
            }

            return dummy.next;
        }
    }
}

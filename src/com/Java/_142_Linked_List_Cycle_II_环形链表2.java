package src.com.Java;

public class _142_Linked_List_Cycle_II_环形链表2 {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // corner case
            if (head == null || head.next == null) {
                return null;
            }

            // normal case
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    while (head != slow) {
                        head = head.next;
                        slow = slow.next;
                    }
                    return head;
                }
            }
            return null;
        }
    }
}

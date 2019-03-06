package src.com.Java;
/*
给定一个链表，判断链表中是否有环。
Use two pointers, walker and runner.
walker moves step by step. runner moves two steps at time.
if the Linked List has a cycle walker and runner will meet at some point.
 */
public class _141_Linked_List_Cycle_环形链表 {
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
        public boolean hasCycle(ListNode head) {
            if (head == null)
                return false;
            ListNode walker = head;
            ListNode runner = head;
            while (runner.next != null && runner.next.next != null) {
                walker = walker.next;
                runner = runner.next.next;
                if (walker == runner)
                    return true;
            }
            return false;
        }
    }
}

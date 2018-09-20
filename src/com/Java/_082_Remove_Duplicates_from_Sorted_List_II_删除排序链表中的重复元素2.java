package src.com.Java;

public class _082_Remove_Duplicates_from_Sorted_List_II_删除排序链表中的重复元素2 {
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
            if (head == null)
                return null;
            ListNode FakeHead = new ListNode(0);
            FakeHead.next = head;
            ListNode pre = FakeHead;
            ListNode cur = head;
            while (cur != null) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                if (pre.next == cur) {
                    pre = pre.next;
                } else {
                    pre.next = cur.next;
                }
                cur = cur.next;
            }
            return FakeHead.next;
        }
    }
}

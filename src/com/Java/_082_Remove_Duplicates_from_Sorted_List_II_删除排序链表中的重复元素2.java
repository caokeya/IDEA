package src.com.Java;
/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
示例 1:
输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:
输入: 1->1->1->2->3
输出: 2->3
 */
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

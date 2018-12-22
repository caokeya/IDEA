package src.com.Java;

/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
示例 1:
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class _061_Rotate_List_旋转链表 {
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) return head;
            ListNode tail = head;
            int len = 1;
            while (tail.next != null) {
                tail = tail.next;
                len++;
            }
            int newHeadIndex = len - (k % len);
            if (newHeadIndex == 0) return head;
            // connect the tail the head
            tail.next = head;
            // get the new head
            ListNode newHead = head;
            ListNode newTail = head;
            for (int i = 0; i < newHeadIndex; i++) {
                newHead = newHead.next;
                if (i > 0) newTail = newTail.next;
            }
            // cut off the tail
            newTail.next = null;
            return newHead;
        }
    }
}

package src.com.Java;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 请判断一个链表是否为回文链表。
 示例 1:
 输入: 1->2
 输出: false
 示例 2:
 输入: 1->2->2->1
 输出: true
*/
public class _234_Palindrome_Linked_List_回文链表 {
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
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            if (head == null || head.next == null) return true;

            // find the middle using a slow & fast pointer
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
                fast = fast.next;
            }

            // reverse the 2nd half of the list using the slow pointer
            slow = reverse(slow);

            // check each element in the second half of the list equals that in the first half.
            while (slow != null) {
                if (head.val != slow.val) {
                    return false;
                }

                head = head.next;
                slow = slow.next;
            }

            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode curr = head;
            ListNode next = null;
            ListNode prev = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    class Solution2 {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            Deque<ListNode> stk = new ArrayDeque();
            ListNode sPtr = head;
            ListNode fPtr = head;
            while (fPtr != null && fPtr.next != null) {
                stk.push(sPtr);
                sPtr = sPtr.next;
                fPtr = fPtr.next.next;
            }
            if (fPtr != null) {//链表长度不是偶数
                sPtr = sPtr.next;
            }
            while (!stk.isEmpty()) {
                if (stk.pop().val != sPtr.val) return false;
                sPtr = sPtr.next;
            }
            return true;
        }
    }
}

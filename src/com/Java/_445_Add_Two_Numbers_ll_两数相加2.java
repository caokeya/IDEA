package src.com.Java;

import java.util.Stack;

/*
给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
示例:
输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出: 7 -> 8 -> 0 -> 7
 */
public class _445_Add_Two_Numbers_ll_两数相加2 {
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

    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<Integer>();
            Stack<Integer> s2 = new Stack<Integer>();

            while (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            ;
            while (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }

            int sum = 0;
            ListNode list = new ListNode(0);
            while (!s1.empty() || !s2.empty()) {
                if (!s1.empty())
                    sum += s1.pop();
                if (!s2.empty())
                    sum += s2.pop();
                list.val = sum % 10;
                ListNode head = new ListNode(sum / 10);
                head.next = list;
                list = head;
                sum /= 10;
            }

            return list.val == 0 ? list.next : list;
        }
    }

}

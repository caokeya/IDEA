package src.com.Java;
/*
给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
示例 :
给定这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class _025_Reverse_Nodes_in_k_Group_每k个一组翻转链表_难 {
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            int count = 0;
            while (curr != null && count != k) { // find the k+1 node
                curr = curr.next;
                count++;
            }
            if (count == k) { // if k+1 node is found
                curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
                                               // head - head-pointer to direct part,
                                               // curr - head-pointer to reversed part;
                while (count-- > 0) { // reverse current k-group:
                    ListNode tmp = head.next; // tmp - next head in direct part
                    head.next = curr; // preappending "direct" head to the reversed list
                    curr = head; // move head of reversed part to a new node
                    head = tmp; // move "direct" head to the next node in direct part
                }
                head = curr;
            }
            return head;
        }
    }
}

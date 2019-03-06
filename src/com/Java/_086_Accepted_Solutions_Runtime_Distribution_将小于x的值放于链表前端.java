package src.com.Java;
/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。
示例:
输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
 */
public class _086_Accepted_Solutions_Runtime_Distribution_将小于x的值放于链表前端 {
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
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0); // dummy heads of the 1st and 2nd queues
            ListNode curr1 = dummy1, curr2 = dummy2; // current tails of the two queues;
            while (head != null) {
                if (head.val < x) {
                    curr1.next = head;
                    curr1 = head;
                } else {
                    curr2.next = head;
                    curr2 = head;
                }
                head = head.next;
            }
            curr2.next = null; // important! avoid cycle in linked list. otherwise u will get TLE.
            curr1.next = dummy2.next;
            return dummy1.next;
        }
    }
}

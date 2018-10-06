package src.com.Java;

/*
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
示例 :
输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
 */
public class _328_Odd_Even_Linked_List_奇偶链表 {
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
        public ListNode oddEvenList(ListNode head) {
            if (head != null) {

                ListNode odd = head, even = head.next, evenHead = even;

                while (even != null && even.next != null) {
                    odd.next = odd.next.next;
                    even.next = even.next.next;
                    odd = odd.next;
                    even = even.next;
                }
                odd.next = evenHead;
            }
            return head;
        }
    }

}

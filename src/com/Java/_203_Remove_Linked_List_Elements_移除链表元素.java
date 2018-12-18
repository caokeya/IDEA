package src.com.Java;

/*
 删除链表中等于给定值 val 的所有节点。
 示例:
 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 */
public class _203_Remove_Linked_List_Elements_移除链表元素 {
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode previous = dummyNode;
            ListNode curr = head;

            while (curr != null) {
                if (curr.val == val) {
                    previous.next = curr.next;
                } else {
                    previous = curr;
                }
                curr = curr.next;
            }
            return dummyNode.next;

        }
    }
}

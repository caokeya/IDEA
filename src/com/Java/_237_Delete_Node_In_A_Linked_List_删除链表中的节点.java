package src.com.Java;

/*
 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 4 -> 5 -> 1 -> 9
 示例 1:
 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 示例 2:
 输入: head = [4,5,1,9], node = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
*/
public class _237_Delete_Node_In_A_Linked_List_删除链表中的节点 {
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
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    class Solution2 {
        // the trick here is to overwrite vals with later vals
        public void deleteNode(ListNode node) {
            if (node == null || node.next == null)
                return;

            ListNode right = node;
            ListNode left = node.next;
            while (left.next != null) {
                right.val = left.val;
                right = right.next;
                left = left.next;
            }

            right.val = left.val;
            right.next = null;
        }
    }
}

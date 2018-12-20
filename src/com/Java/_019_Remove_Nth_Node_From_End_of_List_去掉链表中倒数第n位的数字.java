package src.com.Java;

//去掉链表中倒数第n位的数字
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class _019_Remove_Nth_Node_From_End_of_List_去掉链表中倒数第n位的数字 {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {

			ListNode start = new ListNode(0);
			ListNode slow = start, fast = start;
			slow.next = head;

			// Move fast in front so that the gap between slow and fast becomes n
			for (int i = 1; i <= n + 1; i++) {
				fast = fast.next;
			}
			// Move fast to the end, maintaining the gap
			while (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
			// Skip the desired node
			slow.next = slow.next.next;
			return start.next;
		}
	}
}

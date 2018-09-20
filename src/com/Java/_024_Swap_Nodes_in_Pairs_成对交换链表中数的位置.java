package src.com.Java;

//成对交换链表中数的位置

public class _024_Swap_Nodes_in_Pairs_成对交换链表中数的位置 {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public ListNode swapPairs(ListNode head) {
			if ((head == null) || (head.next == null))
				return head;
			ListNode n = head.next;
			head.next = swapPairs(head.next.next);
			n.next = head;
			return n;
		}
	}
	
}

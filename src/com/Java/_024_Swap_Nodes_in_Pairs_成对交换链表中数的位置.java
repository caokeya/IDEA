package com.Java;

//成对交换链表中数的位置
/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
示例:
给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
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

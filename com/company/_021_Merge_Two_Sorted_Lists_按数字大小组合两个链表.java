package com.company;

//按数字大小组合两个链表

public class _021_Merge_Two_Sorted_Lists_按数字大小组合两个链表 {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null) {
				return l2;
			}
			if (l2 == null) {
				return l1;
			}

			ListNode mergeHead;
			if (l1.val < l2.val) {
				mergeHead = l1;
				mergeHead.next = mergeTwoLists(l1.next, l2);
			} else {
				mergeHead = l2;
				mergeHead.next = mergeTwoLists(l1, l2.next);
			}
			return mergeHead;
		}
	}
	
}

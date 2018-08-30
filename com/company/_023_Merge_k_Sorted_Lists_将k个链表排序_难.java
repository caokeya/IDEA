package com.company;
import java.util.LinkedList;
import java.util.List;

//将k个链表排序

public class  _023_Merge_k_Sorted_Lists_将k个链表排序_难{
	
	//Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {

			if (lists == null || lists.length == 0) {
				return null;
			}

			List<ListNode> tmpLists = new LinkedList<>();

			for (int i = 0; i < lists.length; i += 2) {

				if (i + 1 < lists.length) {
					tmpLists.add(mergeTwoList(lists[i], lists[i + 1]));
				} else {
					tmpLists.add(lists[i]);
				}
			}

			while (tmpLists.size() > 1) { // merge until we got only one left in the list

				ListNode first = tmpLists.remove(0);
				ListNode second = tmpLists.remove(0);
				tmpLists.add(mergeTwoList(first, second));

			}

			return tmpLists.get(0);
		}

		ListNode mergeTwoList(ListNode listA, ListNode listB) {

			ListNode dummy = new ListNode(-1); // dummy
			ListNode current = dummy;

			while (listA != null && listB != null) {
				if (listA.val < listB.val) {
					current.next = listA;
					listA = listA.next;
				} else {
					current.next = listB;
					listB = listB.next;
				}

				current = current.next;
			}

			if (listA != null) {
				current.next = listA;
			} else if (listB != null) {
				current.next = listB;
			}

			return dummy.next;

		}
	}

}

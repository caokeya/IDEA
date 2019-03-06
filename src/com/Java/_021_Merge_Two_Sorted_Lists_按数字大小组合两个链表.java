package src.com.Java;

//按数字大小组合两个链表
/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
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

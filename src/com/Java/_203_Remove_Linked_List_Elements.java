package src.com.Java;

/**
 * @author suzw
 * @version 创建时间：2018年9月3日 下午9:13:48 
 * 类说明:
 * 注意特殊情况: 
 * [1,1] 1
 * [1,2,6,3,4,6,6]  6
 * [2,1]	1
 * 
 */

/*
 * 
 * 	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
 */

public class _203_Remove_Linked_List_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode ans = new ListNode(2);
		ListNode a1 = new ListNode(6);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(6);
		ListNode a4 = new ListNode(6);
		head.next = ans;
		ans.next = a1;
		a1.next=a2;
		a2.next=a3;
		a3.next=a4;
		//removeElements(head, 1);
		System.out.println(ans=removeElementsByRecursion(head, 6));
		//last = newHead.next;
		while(ans!=null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

	public static ListNode removeElementsByRecursion(ListNode head,int val) {
		if (head == null)	 return null;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next:head;
	}
	public static ListNode removeElements(ListNode head, int val) {
		
		
		ListNode newHead =new ListNode(0);
		ListNode last = newHead;

		if (head == null || (head.next == null && head.val == val)) {
			return null;
		}
		
		while(head!=null) {
			if (head.val !=val) {
				last.next = new ListNode(head.val);
				last = last.next;
				
				System.out.println("head:"+head.val+",last.val:"+last.val);
			}
				head = head.next;
		}
		
		last = newHead.next;
		while(last!=null) {
			System.out.println(last.val);
			last = last.next;
		}
		
		return newHead.next;
	}
	
	public static ListNode removeElements2(ListNode head, int val) {
			
			
			ListNode newHead =new ListNode(0);
			ListNode last = newHead;
			if (head == null || (head.next == null && head.val == val)) {
				return null;
			}
			
			newHead.next = head;
			while(last.next!=null) {
				if (last.next.val == val) {
						last.next = last.next.next;
					
				}
				else {
					last = last.next;
					
				}
				if (last == null) {break;
				
				}
			}
			return newHead.next;
	}
}

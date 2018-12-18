package src.com.Java; /**
 * 
 */
/** 
* @author  suzw
* @version 创建时间：2018年9月6日 下午1:09:13 
* 类说明 
*/
/*

*@author: suzw
*@date: 2018年9月6日下午1:09:26
*@TODO
*/

public class _206_Reverse_Linked_List_反转链表 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode ans = new ListNode(2);
		ListNode a1 = new ListNode(6);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(-6);
		ListNode a4 = new ListNode(6);
		ListNode a5 =null;
		head.next = ans;
		ans.next = a1;
		a1.next=a2;
		a2.next=a3;
		a3.next=a4;
		reverseList(a5);
	}
	public static ListNode reverseList(ListNode head) {

		int length = getLinkedListLength(head);
		if (length == 0) {
			return null;
		}
		int[] listToInt = new int[length];
		
		//顺序取出
		ListNode temp = head;
		for (int i = 0; i < length; i++) {
			listToInt[i] = temp.val;
			temp = temp.next;
		}
		//逆序存放回原链表
		temp = head;
		for (int i = 0; i <length; i++) {
			temp.val = listToInt[length-i-1];
			temp = temp.next;
			
		}
		printLinkedList(head);
		return head;
		
	}
	
	
	public static void printLinkedList(ListNode last) {
		
		while(last!=null) {
			System.out.println(last.val);
			last = last.next;
		}
	}
	public static int getLinkedListLength(ListNode head) {
		int length = 0;
		while(head!=null)
		{
			length++;
			head=head.next;
		}
		return length;
	}
	

}

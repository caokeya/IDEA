package src.com.Java;

/** 
* @author  suzw
* @version 创建时间：2018年9月29日 下午2:49:00 
* 类说明 
* Given a singly linked list, determine if it is a palindrome.
Example 1:
Input: 1->2
Output: false
Example 2:
Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
1、遍历整个链表，将链表每个节点的值记录在数组中，再判断数组是不是一个回文数组，时间复杂度为O（n），
      但空间复杂度也为O（n），不满足空间复杂度要求。
2、利用栈先进后出的性质，将链表前半段压入栈中，再逐个弹出与链表后半段比较。时间复杂度O（n），
      但仍然需要n/2的栈空间，空间复杂度为O（n）。
3、反转链表法，将链表后半段原地翻转，再将前半段、后半段依次比较，判断是否相等，时间复杂度O（n），
      空间复杂度为O（1）满足题目要求。

---------------------

本文来自 大胃孙 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/sunao2002002/article/details/46918645?utm_source=copy 
*/
public class _234_Palindrome_Linked_List_回文链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
    public static boolean isPalindrome(ListNode head) {
    	//0或1个节点
        if (head==null || head.next==null) 		return true;
        ListNode slow = head;
        ListNode fast = head;
    	//将slow指向链表的中间节点
        while(fast.next!=null && fast.next.next !=null) {
        	fast= fast.next.next;
        	slow = slow.next;
        }
        //对链表进行反转
        //ListNode 
        //ListNode reverseHead = slow.next;	//后半段的第一个节点
        ListNode cur = slow.next;			//插入的节点从后半段第一个节点的后一个开始
        //reverseHead.next = null;			//后半段的第一个节点将变成最后一个节点
        ListNode prev = null;
        //现在reverseHead和cur都指向了后半段的头节点，这个节点将变成最后一个节点
        //将后半段的next都反着指向就完成了反转
        //cur作为中间变量
        while(cur!=null) {
        	ListNode next = cur.next;
        	cur.next = prev;
        	prev = cur;
        	cur = next;
        }
        //此时，pre指向了最后一个节点，再将pre和head进行比较
        while(prev!=null) {
        	if (prev.val != head.val) {
				return false;
			}
        	prev = prev.next;
        	head = head.next;
        }
        
    	return true;
    }
}

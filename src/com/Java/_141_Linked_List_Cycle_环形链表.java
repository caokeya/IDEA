package src.com.Java;
/*
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class _141_Linked_List_Cycle_环形链表 {
    /*
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null)
                return false;
            ListNode walker = head;
            ListNode runner = head;
            while (runner.next != null && runner.next.next != null) {
                walker = walker.next;
                runner = runner.next.next;
                if (walker == runner)
                    return true;
            }
            return false;
        }
    }
}

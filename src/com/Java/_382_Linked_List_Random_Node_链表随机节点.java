package src.com.Java;

import java.util.Random;

/*
给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
进阶:
如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
示例:
 初始化一个单链表 [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);
getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
solution.getRandom();
 */
public class _382_Linked_List_Random_Node_链表随机节点 {
    /*
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        /*
         * @param head The linked list's head.
         * Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        ListNode first;
        Random random;

        public Solution(ListNode head) {
            first = head;
            random = new Random();
        }

        /*
         * Returns a random node's value.
         */
        public int getRandom() {
            int result = first.val;
            ListNode cur = first;
            for (int i = 1; cur.next != null; i++) {
                cur = cur.next;
                if (random.nextInt(i + 1) == i) {
                    result = cur.val;
                }
            }
            return result;
        }
    }
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
}

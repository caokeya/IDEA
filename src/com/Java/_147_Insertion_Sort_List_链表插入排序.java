package src.com.Java;

/*
对链表进行插入排序。
插入排序算法：
    插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    重复直到所有输入数据插入完为止。
示例 1：
输入: 4->2->1->3
输出: 1->2->3->4
示例 2：
输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */
public class _147_Insertion_Sort_List_链表插入排序 {
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
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode helper = new ListNode(0); //new starter of the sorted list
            ListNode cur = head; //the node will be inserted
            ListNode pre = helper; //insert node between pre and pre.next
            ListNode next = null; //the next node will be inserted
            //not the end of input list
            while (cur != null) {
                next = cur.next;
                //find the right place to insert
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                //insert between pre and pre.next
                cur.next = pre.next;
                pre.next = cur;
                pre = helper;
                cur = next;
            }

            return helper.next;
        }
    }

    class Solution2 {
        /*
         * T(n): O(n^2) S(n): O(1)
         */
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.next.val >= curr.val) {
                    curr = curr.next;
                } else {
                    ListNode tmp = curr.next;
                    curr.next = tmp.next;
                    ListNode prev = dummy;
                    while (tmp.val >= prev.next.val) {
                        prev = prev.next;
                    }
                    tmp.next = prev.next;
                    prev.next = tmp;
                }
            }
            return dummy.next;
        }
    }
}

package src.com.Java;

/*
给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
返回一个符合上述规则的链表的列表。
举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
示例 1：
输入: 
root = [1, 2, 3], k = 5
输出: [[1],[2],[3],[],[]]
解释:
输入输出各部分都应该是链表，而不是数组。
例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
示例 2：
输入: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
解释:
输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 */
public class _725_Split_Linked_List_in_Parts_分隔链表 {
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
        public ListNode[] splitListToParts(ListNode root, int k) {
            if (root == null)
                return new ListNode[k];
            ListNode[] res = new ListNode[k];
            int len = getLen(root);
            int avg = len / k;
            int leftOver = len % k;
            ListNode node = root, prev = null;
            for (int start = 0; node != null && start < k; start++, leftOver--) {
                res[start] = node;
                int tempLen = leftOver > 0 ? 1 + avg : avg;
                for (int j = 0; j < tempLen; j++) {
                    prev = node;
                    node = node.next;
                }
                prev.next = null;
            }
            return res;
        }

        private int getLen(ListNode root) {
            int count = 0;
            while (root != null) {
                root = root.next;
                count++;
            }
            return count;
        }
    }
}

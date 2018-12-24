package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的深度拷贝。 
 */
public class _138_Copy_List_with_Random_Pointer_复制带随机指针的链表 {
    /*
     * Definition for singly-linked list with a random pointer.
     */
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null)
                return null;
            Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
            // loop 1. copy all the nodes
            RandomListNode node = head;
            while (node != null) {
                map.put(node, new RandomListNode(node.label));
                node = node.next;
            }
            // loop 2. assign next and random pointers
            node = head;
            while (node != null) {
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
                node = node.next;
            }
            return map.get(head);
        }
    }
}

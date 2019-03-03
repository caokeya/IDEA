package com.Java;

import java.util.HashMap;
/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的深度拷贝。 
 */
public class _138_Copy_List_with_Random_Pointer_复制带随机指针的链表 {
    /**
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
            HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode it = head;
            while (it != null) {
                map.put(it, new RandomListNode(it.label));
                it = it.next;
            }
            it = head;
            while (it != null) {
                map.get(it).next = map.get(it.next);
                map.get(it).random = map.get(it.random);
                it = it.next;
            }
            return map.get(head);
        }
    }
}

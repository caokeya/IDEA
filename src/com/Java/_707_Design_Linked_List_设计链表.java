package com.Java;

import java.util.LinkedList;

/*
设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
在链表类中实现这些功能：
    get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
                                                            如果 index 等于链表的长度，则该节点将附加到链表的末尾。
                                                            如果 index 大于链表长度，则不会插入节点。
    deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
示例：
MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
linkedList.get(1);            //返回2
linkedList.deleteAtIndex(1);  //现在链表是1-> 3
linkedList.get(1);            //返回3
 */
public class _707_Design_Linked_List_设计链表 {
    class MyLinkedList {

        private DoublyLinkedListNode head = null;

        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /**
         * Get the value of the index-th node in the linked list. 
         * If the index is invalid, return -1.
         */
        public int get(int index) {

            if (head == null || index < 0) {
                return -1;
            }

            if (index == 0) {
                return head.val;
            }

            DoublyLinkedListNode curr = head;

            for (int i = 0; i < index; i++) {
                if (curr.next != null) {
                    curr = curr.next;
                } else {
                    curr = null;
                    break;
                }
            }

            if (curr == null) {
                return -1;
            }

            return curr.val;
        }

        /**
         * Add a node of value val before the first element of the linked list.
         * After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(val);

            if (head == null) {
                head = node;
                return;
            }

            node.next = head;
            head.prev = node;
            head = node;

        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(val);

            if (head == null) {
                head = node;
                return;
            }

            DoublyLinkedListNode curr = head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = node;
            node.prev = curr;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index
         * equals to the length of linked list, the node will be appended to the end of
         * linked list. If index is greater than the length, the node will not be
         * inserted.
         */
        public void addAtIndex(int index, int val) {

            if (head == null && index < 0) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            DoublyLinkedListNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                if (curr.next == null) {
                    return;
                }
                curr = curr.next;
            }

            if (curr != null) {
                DoublyLinkedListNode node = new DoublyLinkedListNode(val);
                DoublyLinkedListNode tempNext = curr.next;

                curr.next = node;

                node.prev = curr;
                node.next = tempNext;

                if (tempNext != null) {
                    tempNext.prev = node;
                }
            }

        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {

            if (head == null || index < 0) {
                return;
            }

            if (index == 0) {
                DoublyLinkedListNode tempNext = head.next;
                tempNext.prev = null;
                head = tempNext;
                return;
            }

            DoublyLinkedListNode curr = head;
            for (int i = 0; i < index; i++) {
                if (curr.next == null) {
                    return;
                }
                curr = curr.next;
            }

            if (curr != null) {
                if (curr.prev == null) {
                    DoublyLinkedListNode tempNext = curr.next;
                    tempNext.prev = null;
                    return;
                }

                if (curr.next == null) {
                    DoublyLinkedListNode tempPrev = curr.prev;
                    tempPrev.next = null;
                    return;
                }

                DoublyLinkedListNode tempNext = curr.next;
                DoublyLinkedListNode tempPrev = curr.prev;
                tempPrev.next = tempNext;

                tempNext.prev = tempPrev;
            }
        }
    }

    public class DoublyLinkedListNode {
        int val;
        DoublyLinkedListNode prev, next;

        public DoublyLinkedListNode(int val) {
            this.val = val;
        }
    }

    class MyLinkedList2 {
        LinkedList<Integer> list = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyLinkedList2() {

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            return index < list.size() ? list.get(index) : -1;
        }

        /**
         * Add a node of value val before the first element of the linked list. 
         * After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            list.addFirst(val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            list.add(val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. 
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > list.size())
                return;
            list.add(index, val);
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= list.size())
                return;
            list.remove(index);
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
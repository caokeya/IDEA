package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 */
//LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
/*
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
*/
public class _146_LRU_Cache_LRU缓存机制_难 {
    class LRUCache {
        class DLinkNode {
            int key;
            int value;
            DLinkNode pre;
            DLinkNode post;
        }

        private Map<Integer, DLinkNode> map = new HashMap<>();
        private int count;
        private int capacity;
        private DLinkNode head;
        private DLinkNode tail;

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkNode();
            head.pre = null;

            tail = new DLinkNode();
            tail.post = null;

            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkNode node = map.get(key);
            if (node == null) {
                return -1; // should raise exception here.

            }
            // move the accessed node to the head;
            this.moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkNode node = map.get(key);

            if (node == null) {

                DLinkNode newNode = new DLinkNode();
                newNode.key = key;
                newNode.value = value;

                this.map.put(key, newNode);
                this.addNode(newNode);

                ++count;

                if (count > capacity) {
                    // pop the tail
                    DLinkNode tail = this.popTail();
                    this.map.remove(tail.key);
                    count--;
                }
            } else {
                // update the value.
                node.value = value;
                this.moveToHead(node);
            }
        }

        /*
         * Always add the new node right after head;
         */
        private void addNode(DLinkNode node) {
            node.pre = head;
            node.post = head.post;

            head.post.pre = node;
            head.post = node;
        }

        /*
         * Remove an existing node from the linked list.
         */
        private void removeNode(DLinkNode node) {
            DLinkNode pre = node.pre;
            DLinkNode post = node.post;

            pre.post = post;
            post.pre = pre;
        }

        /*
         * Move certain node in between to the head.
         */
        private void moveToHead(DLinkNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        // pop the current tail.
        private DLinkNode popTail() {
            DLinkNode res = tail.pre;
            this.removeNode(res);
            return res;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such: LRUCache obj =
     * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
     */

}

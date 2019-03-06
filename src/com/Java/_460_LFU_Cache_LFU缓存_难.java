package src.com.Java;

import java.util.HashMap;
import java.util.LinkedHashSet;

/*
设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，
使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
示例：
LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) 
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回 1
cache.put(3, 3);    // 去除 key 2
cache.get(2);       // 返回 -1 (未找到key 2)
cache.get(3);       // 返回 3
cache.put(4, 4);    // 去除 key 1
cache.get(1);       // 返回 -1 (未找到 key 1)
cache.get(3);       // 返回 3
cache.get(4);       // 返回 4
*/
public class _460_LFU_Cache_LFU缓存_难 {

    class LFUCache {
        HashMap<Integer, Integer> vals;
        HashMap<Integer, Integer> counts;
        HashMap<Integer, LinkedHashSet<Integer>> lists;
        int cap;
        int min;

        public LFUCache(int capacity) {
            vals = new HashMap<>();
            counts = new HashMap<>();
            lists = new HashMap<>();
            cap = capacity;
            min = 0;
        }

        public int get(int key) {
            if (!vals.containsKey(key))
                return -1;

            update(key);
            return vals.get(key);
        }

        private void update(int key) {
            int cnt = counts.get(key);
            counts.put(key, cnt + 1);
            lists.get(cnt).remove(key);

            if (cnt == min && lists.get(cnt).size() == 0)
                min++;

            addToList(cnt + 1, key);
        }

        private void addToList(int cnt, int key) {
            if (!lists.containsKey(cnt))
                lists.put(cnt, new LinkedHashSet<>());

            lists.get(cnt).add(key);
        }

        private void evict() {
            int key = lists.get(min).iterator().next();
            lists.get(min).remove(key);
            vals.remove(key);
            counts.remove(key);
        }

        public void put(int key, int value) {
            if (cap <= 0)
                return;

            if (vals.containsKey(key)) {
                vals.put(key, value);
                update(key);
                return;
            }

            if (vals.size() >= cap)
                evict();

            vals.put(key, value);
            counts.put(key, 1);
            addToList(1, key);
            min = 1;
        }
    }
    /**
     * Your LFUCache object will be instantiated and called as such: LFUCache obj =
     * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
     */

}

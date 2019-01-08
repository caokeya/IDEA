package src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
实现一个数据结构支持以下操作：
    Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
    Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。
               如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
    GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
    GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 */
public class _432_All_one_Data_Structure_全O1的数据结构_难 {
    public class AllOne {
        // maintain a doubly linked list of Buckets
        private Bucket head;
        private Bucket tail;
        // for accessing a specific Bucket among the Bucket list in O(1) time
        private Map<Integer, Bucket> countBucketMap;
        // keep track of count of keys
        private Map<String, Integer> keyCountMap;

        // each Bucket contains all the keys with the same count
        private class Bucket {
            int count;
            Set<String> keySet;
            Bucket next;
            Bucket pre;

            public Bucket(int cnt) {
                count = cnt;
                keySet = new HashSet<>();
            }
        }

        /*
         * Initialize your data structure here.
         */
        public AllOne() {
            head = new Bucket(Integer.MIN_VALUE);
            tail = new Bucket(Integer.MAX_VALUE);
            head.next = tail;
            tail.pre = head;
            countBucketMap = new HashMap<>();
            keyCountMap = new HashMap<>();
        }

        /*
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            if (keyCountMap.containsKey(key)) {
                changeKey(key, 1);
            } else {
                keyCountMap.put(key, 1);
                if (head.next.count != 1)
                    addBucketAfter(new Bucket(1), head);
                head.next.keySet.add(key);
                countBucketMap.put(1, head.next);
            }
        }

        /*
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data
         * structure.
         */
        public void dec(String key) {
            if (keyCountMap.containsKey(key)) {
                int count = keyCountMap.get(key);
                if (count == 1) {
                    keyCountMap.remove(key);
                    removeKeyFromBucket(countBucketMap.get(count), key);
                } else {
                    changeKey(key, -1);
                }
            }
        }

        /*
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            return tail.pre == head ? "" : (String) tail.pre.keySet.iterator().next();
        }

        /*
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            return head.next == tail ? "" : (String) head.next.keySet.iterator().next();
        }

        // helper function to make change on given key according to offset
        private void changeKey(String key, int offset) {
            int count = keyCountMap.get(key);
            keyCountMap.put(key, count + offset);
            Bucket curBucket = countBucketMap.get(count);
            Bucket newBucket;
            if (countBucketMap.containsKey(count + offset)) {
                // target Bucket already exists
                newBucket = countBucketMap.get(count + offset);
            } else {
                // add new Bucket
                newBucket = new Bucket(count + offset);
                countBucketMap.put(count + offset, newBucket);
                addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.pre);
            }
            newBucket.keySet.add(key);
            removeKeyFromBucket(curBucket, key);
        }

        private void removeKeyFromBucket(Bucket bucket, String key) {
            bucket.keySet.remove(key);
            if (bucket.keySet.size() == 0) {
                removeBucketFromList(bucket);
                countBucketMap.remove(bucket.count);
            }
        }

        private void removeBucketFromList(Bucket bucket) {
            bucket.pre.next = bucket.next;
            bucket.next.pre = bucket.pre;
            bucket.next = null;
            bucket.pre = null;
        }

        // add newBucket after preBucket
        private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
            newBucket.pre = preBucket;
            newBucket.next = preBucket.next;
            preBucket.next.pre = newBucket;
            preBucket.next = newBucket;
        }
    }
    /**
     * Your AllOne object will be instantiated and called as such:
     * AllOne obj = new AllOne();
     * obj.inc(key);
     * obj.dec(key);
     * String param_3 = obj.getMaxKey();
     * String param_4 = obj.getMinKey();
     */
}

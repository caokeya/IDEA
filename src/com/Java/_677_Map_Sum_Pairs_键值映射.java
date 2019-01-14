package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
实现一个 MapSum 类里的两个方法，insert 和 sum。
对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
示例 1:
输入: insert("apple", 3), 输出: Null
输入: sum("ap"), 输出: 3
输入: insert("app", 2), 输出: Null
输入: sum("ap"), 输出: 5
 */
public class _677_Map_Sum_Pairs_键值映射 {
    class MapSum {

        Map<String, Integer> mem;
        Map<String, Integer> set;

        /*
         * Initialize your data structure here.
         */
        public MapSum() {
            mem = new HashMap<>();
            set = new HashMap<>();
        }

        public void insert(String key, int val) {
            if (!set.containsKey(key)) {
                set.put(key, val);
                for (int i = 0; i <= key.length(); i++) {
                    String sub = key.substring(0, i);
                    mem.put(sub, mem.getOrDefault(sub, 0) + val);
                }
            } else {
                int cnt = set.get(key);
                for (int i = 0; i <= key.length(); i++) {
                    String sub = key.substring(0, i);
                    mem.put(sub, mem.get(sub) - cnt + val);
                }
            }
        }

        public int sum(String prefix) {
            if (!mem.containsKey(prefix))
                return 0;
            return mem.get(prefix);
        }
    }

    class MapSumStartsWith {
        Map<String, Integer> map = new HashMap<>();

        /*
         * Initialize your data structure here.
         */
        public MapSumStartsWith() {

        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (String str : map.keySet()) {
                if (str.startsWith(prefix)) {
                    sum += map.get(str);
                }
            }

            return sum;
        }
    }
    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
}

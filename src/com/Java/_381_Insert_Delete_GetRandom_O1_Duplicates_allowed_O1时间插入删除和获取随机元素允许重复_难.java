package com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
注意: 允许出现重复元素。
    insert(val)：向集合中插入元素 val。
    remove(val)：当 val 存在时，从集合中移除一个 val。
    getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
示例:
// 初始化一个空的集合。
RandomizedCollection collection = new RandomizedCollection();
// 向集合中插入 1 。返回 true 表示集合不包含 1 。
collection.insert(1);
// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
collection.insert(1);
// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
collection.insert(2);
// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
collection.getRandom();
// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
collection.remove(1);
// getRandom 应有相同概率返回 1 和 2 。
collection.getRandom();
 */
public class _381_Insert_Delete_GetRandom_O1_Duplicates_allowed_O1时间插入删除和获取随机元素允许重复_难 {
    public class RandomizedCollection {

        List<Integer> nums;
        Map<Integer, Set<Integer>> map;
        java.util.Random random;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            nums = new ArrayList<>();
            map = new HashMap<>();
            random = new java.util.Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not
         * already contain the specified element.
         */
        public boolean insert(int val) {
            boolean doesContain = map.containsKey(val);
            if (!doesContain)
                map.put(val, new HashSet<>());
            map.get(val).add(nums.size());
            nums.add(val);
            return !doesContain;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained
         * the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
            if (!map.get(val).contains(nums.size() - 1)) {
                int currPos = map.get(val).iterator().next();
                int lastVal = nums.get(nums.size() - 1);
                map.get(lastVal).remove(nums.size() - 1);
                map.get(lastVal).add(currPos);
                map.get(val).remove(currPos);
                map.get(val).add(nums.size() - 1);
                nums.set(currPos, lastVal);
            }
            map.get(val).remove(nums.size() - 1);
            if (map.get(val).isEmpty())
                map.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}

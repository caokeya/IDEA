package src.com.Java;

import java.util.*;

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
    class RandomizedCollection {
        private Map<Integer, ArrayList<Integer>> map;
        private ArrayList<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean flag = !map.containsKey(val);
            if (flag) {
                //the collection does not contain the element
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(list.size());
            list.add(val);
            return flag;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            boolean flag = map.containsKey(val);
            //System.out.println(list.toString());
            if (flag) {
                //if flag contains key, then remove it, always remove the last one
                ArrayList<Integer> pos = map.get(val);
                //System.out.println(pos.toString());
                int removePos = pos.get(pos.size() - 1);
                pos.remove(pos.size() - 1);
                if (pos.size() == 0) {
                    map.remove(val);
                }
                if (removePos != list.size() - 1) {
                    list.set(removePos, list.get(list.size() - 1));
                    //you also need to update the pos in the list Integer
                    ArrayList<Integer> lastVal = map.get(list.get(list.size() - 1));
                    Collections.sort(lastVal);
                    lastVal.remove(lastVal.size() - 1);
                    lastVal.add(removePos);
                }
                list.remove(list.size() - 1);
                //when we set the
            }
            return flag;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            int random = (int) (Math.random() * list.size());
            return list.get(random);
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

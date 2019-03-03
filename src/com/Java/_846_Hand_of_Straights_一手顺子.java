package com.Java;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
爱丽丝有一手（hand）由整数数组给定的牌。 
现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
如果她可以完成分组就返回 true，否则返回 false。
示例 1：
输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
输出：true
解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
示例 2：
输入：hand = [1,2,3,4,5], W = 4
输出：false
解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 */
public class _846_Hand_of_Straights_一手顺子 {
    class Solution {
        public boolean isNStraightHand(int[] hand, int W) {
            // Firstly sort the array and get the count of each number with a TreeMap
            // Then try to generate these groups which have W consecutive cards
            // O(NlogN)
            int n = hand.length;
            if (n % W != 0)
                return false;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i : hand) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            while (map.size() > 0) {
                int firstNum = map.firstKey();
                for (int i = 0; i < W; i++) {
                    int cur = firstNum + i;
                    if (!map.containsKey(cur))
                        return false;
                    else {
                        map.put(cur, map.get(cur) - 1);
                        if (map.get(cur) <= 0)
                            map.remove(cur);
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isNStraightHand(int[] hand, int W) {
            // 用map储存各有几个点，每次找最小的然后看看够不够
            // 可以用priorityQueue, 用map可能有concurrent issue?
            // 其实也可以用treemap，只是条件判断只需要while(!map.isEmpty())
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int h : hand)
                pq.add(h);

            while (!pq.isEmpty()) {
                int small = pq.peek();

                for (int i = 0; i < W; i++) {
                    // remove 操作是 logN
                    if (!pq.remove(small++))
                        return false;
                }
            }
            return true;
        }
    }
}

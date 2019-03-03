package com.Java;

import java.util.Map;
import java.util.TreeMap;

/*
给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
返回 A 的任意排列，使其相对于 B 的优势最大化。
示例 1：
输入：A = [2,7,11,15], B = [1,10,4,11]
输出：[2,11,7,15]
示例 2：
输入：A = [12,24,8,32], B = [13,25,32,11]
输出：[24,32,8,12]
 */
public class _870_Advantage_Shuffle_优势洗牌 {
    class Solution {
        public int[] advantageCount(int[] A, int[] B) {
            // 田忌赛马
            // 运用田忌赛马的思路，如果A中有相应的higher元素，使用最小的higher元素。否则使用A中最小的元素 
            // the tree map stores <value, count> pairs of array A
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : A) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // for each value in B, get the A entry with smallest higher key or the smallest
            // key if not exist
            int[] res = new int[A.length];

            for (int i = 0; i < B.length; i++) {
                Map.Entry<Integer, Integer> matchingEntry = map.higherEntry(B[i]);//找到大于等于的最相近的一个键值对
                if (matchingEntry == null) {
                    matchingEntry = map.firstEntry();//找到最小的一个
                }

                res[i] = matchingEntry.getKey();
                if (matchingEntry.getValue() == 1) {
                    map.remove(matchingEntry.getKey());
                } else {
                    map.put(matchingEntry.getKey(), matchingEntry.getValue() - 1);
                }
            }

            return res;
        }
    }
}

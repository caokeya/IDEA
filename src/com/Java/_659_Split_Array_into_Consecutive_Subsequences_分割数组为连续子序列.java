package com.Java;

import java.util.HashMap;
import java.util.Map;

/*
输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
示例 1：
输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3
3, 4, 5
示例 2：
输入: [1,2,3,3,4,4,5,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3, 4, 5
3, 4, 5
示例 3：
输入: [1,2,3,4,4,5]
输出: False
 */
public class _659_Split_Array_into_Consecutive_Subsequences_分割数组为连续子序列 {
    class Solution {
        public boolean isPossible(int[] nums) {
            if (nums.length < 3)
                return false;

            // frequency map
            Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
            for (int i : nums) {
                freq.put(i, freq.getOrDefault(i, 0) + 1);
            }

            // iterate again
            // 1. if it can be appended to a previously constructed consecutive sequence
            // 2. if it can be the start of a new consecutive sequence.
            // 3. if neither are true, then we return false
            for (int i : nums) {
                if (freq.get(i) == 0)
                    continue;

                if (appendfreq.getOrDefault(i, 0) > 0) {
                    appendfreq.put(i, appendfreq.get(i) - 1);
                    appendfreq.put(i + 1, appendfreq.getOrDefault(i + 1, 0) + 1);
                } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                    freq.put(i + 1, freq.get(i + 1) - 1);
                    freq.put(i + 2, freq.get(i + 2) - 1);
                    appendfreq.put(i + 3, appendfreq.getOrDefault(i + 3, 0) + 1);
                } else {
                    return false;
                }

                freq.put(i, freq.get(i) - 1);
            }
            return true;
        }
    }
}

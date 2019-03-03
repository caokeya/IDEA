package com.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
示例 1:
输入: [1,3,2,2,5,2,3,7]
输出: 5
原因: 最长的和谐数组是：[3,2,2,2,3].
 */
public class _594_Longest_Harmonious_Subsequence_最长和谐子序列 {
    class Solution {
        public int findLHS(int[] nums) {
            Map<Long, Integer> map = new HashMap<>();
            for (long num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int result = 0;
            for (long key : map.keySet()) {
                if (map.containsKey(key + 1)) {
                    result = Math.max(result, map.get(key + 1) + map.get(key));
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int findLHS(int[] nums) {

            Arrays.sort(nums);

            int min = 0, count = 0;

            for (int i = 0; i < nums.length;) {

                if (nums[i] == nums[min])
                    i++;
                else if (nums[min] + 1 == nums[i]) {

                    count = Math.max(i - min + 1, count);
                    i++;
                } else
                    min++;

            }
            return count;
        }
    }
}

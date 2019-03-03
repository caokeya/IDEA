package com.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
给定一个未排序的整数数组，找出最长连续序列的长度。
示例:
输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class _128_Longest_Consecutive_Sequence_最长连续序列 {
    class Solution {
        public int longestConsecutive(int[] nums) {

            Set<Integer> set = new HashSet<Integer>();

            for (int i : nums) {
                set.add(i);
            }

            int streak = 0;
            int maxStreak = 0;
            for (int i : set) {

                if (!set.contains(i - 1)) {

                    while (set.contains(i)) {
                        streak++;
                        i++;
                    }
                    maxStreak = Math.max(maxStreak, streak);
                    streak = 0;
                }

            }

            return maxStreak;
        }
    }
    
    class SolutionSort {
        public int longestConsecutive(int[] nums) {
            if(nums.length<=1) return nums.length;
            int count=1;
            int ret=1;
            Arrays.sort(nums);
            for(int i=1;i<nums.length;i++){
                if(nums[i-1] ==nums[i] - 1){
                    count++;
                    ret=Math.max(ret,count);
                }
                else if(nums[i-1] < nums[i] - 1){
                    count=1;
                }
            }
            return ret;
        }
    }
}

package com.Java;
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class _136_Single_Number_找到只出现了一次的数字 {
    class Solution {
        public int singleNumber(int[] nums) {
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }
            return res;
        }
    }
}

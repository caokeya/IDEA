package com.Java;

/*
集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
示例 1:
输入: nums = [1,2,2,4]
输出: [2,3]
 */
public class _645_Set_Mismatch_错误的集合 {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] arr = new int[nums.length + 1];
            int dup = -1, missing = 1;
            for (int i : nums) {
                arr[i] += 1;
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0)
                    missing = i;
                else if (arr[i] == 2)
                    dup = i;
            }
            return new int[] { dup, missing };
        }
    }
}

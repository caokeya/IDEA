package com.Java;

/*
给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
示例：
给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */
public class _303_Range_Sum_Query_Immutable_区域和检索数组不可变 {
    class NumArray {

        int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such: 
     * NumArray obj =new NumArray(nums); 
     * int param_1 = obj.sumRange(i,j);
     */
}

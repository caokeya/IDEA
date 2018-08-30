package com.company;

import java.util.Arrays;

public class _031_Next_Permutation_下一个排列 {
    class Solution {
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 2; i >= 0; i--) {
                // 寻找可以替换的最低位
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        // 确保替换位的后续位的值最小
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
                // 若当前位不可替换，则自当前位开始排序，以保证下一位可以在不进行完整遍历的前提下找到最小的更大值
                Arrays.sort(nums, i, nums.length);
            }
        }
    }
}

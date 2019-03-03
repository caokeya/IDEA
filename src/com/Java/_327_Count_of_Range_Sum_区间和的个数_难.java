package com.Java;
/*
给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
示例:
输入: nums = [-2,5,-1], lower = -2, upper = 2,
输出: 3 
解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 */
public class _327_Count_of_Range_Sum_区间和的个数_难 {
    public class Solution {
        long[] tmp;

        public int countRangeSum(int[] nums, int lower, int upper) {
            int len = nums.length;
            long[] sum = new long[len + 1];
            tmp = new long[len + 1];
            for (int i = 1; i <= len; i++)
                sum[i] = sum[i - 1] + nums[i - 1];
            return msCount(sum, 0, len, lower, upper);
        }

        public int msCount(long[] nums, int start, int end, int lower, int upper) {
            if (start >= end) {
                return 0;
            }
            int mid = start + (end - start) / 2;
            int ans = msCount(nums, start, mid, lower, upper) + msCount(nums, mid + 1, end, lower, upper);
            int p1 = start, p2 = start;
            for (int i = mid + 1; i <= end; i++) {
                long low = nums[i] - upper;
                long high = nums[i] - lower;
                while (p1 <= mid && nums[p1] < low) {
                    p1++;
                }
                while (p2 <= mid && nums[p2] <= high) {
                    p2++;
                }
                ans += p2 - p1;
            }
            merge(nums, start, end);
            return ans;
        }

        public void merge(long[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = start + (end - start) / 2;
            int p3 = start, p4 = mid + 1;
            int k = start;
            while (p3 <= mid || p4 <= end) {
                if (p4 > end || p3 <= mid && nums[p3] <= nums[p4]) {
                    tmp[k++] = nums[p3++];
                } else {
                    tmp[k++] = nums[p4++];
                }
            }
            for (int i = start; i <= end; i++)
                nums[i] = tmp[i];
        }
    }
}

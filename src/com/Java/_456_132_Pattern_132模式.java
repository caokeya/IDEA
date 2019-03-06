package src.com.Java;

import java.util.Arrays;

/*
给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
注意：n 的值小于15000。
示例1:
输入: [1, 2, 3, 4]
输出: False
解释: 序列中不存在132模式的子序列。
示例 2:
输入: [3, 1, 4, 2]
输出: True
解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 */
public class _456_132_Pattern_132模式 {
    /*
     * One-pass O(n) solution
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third)
                return true;
            while (top < n && nums[i] > nums[top])
                third = nums[top++];
            nums[--top] = nums[i];
        }

        return false;
    }
    
    /*
     * Optimized O(n) solution
     */
    public boolean find132pattern1(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j])
                continue;
            while (top < nums.length && arr[top] <= arr[j])
                top++;
            if (top < nums.length && nums[j] > arr[top])
                return true;
            arr[--top] = nums[j];
        }

        return false;
    }

    /*
     * Improved O(n^2) solution
     */
    public boolean find132pattern2(int[] nums) {
        for (int j = 0, min = Integer.MAX_VALUE; j < nums.length; j++) {
            min = Math.min(nums[j], min);
            if (min == nums[j])
                continue;

            for (int k = nums.length - 1; k > j; k--) {
                if (min < nums[k] && nums[k] < nums[j])
                    return true;
            }
        }

        return false;
    }
    
    /*
     *  Naive O(n^3) solution
     *  The naive O(n^3) solution is a no-brainer --- simply check every (i, j, k) combination to see if there is any 132 pattern.
     */
    public boolean find132pattern3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j])
                        return true;
                }
            }
        }
        return false;
    }
}

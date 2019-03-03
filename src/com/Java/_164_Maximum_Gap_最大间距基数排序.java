package com.Java;

/*
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
如果数组元素个数小于 2，则返回 0。
示例 1:
输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
//基数排序 https://www.cs.usfca.edu/~galles/visualization/RadixSort.html
public class _164_Maximum_Gap_最大间距基数排序 {
    class Solution {

        public int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }

            // m is the maximal number in nums
            int m = nums[0];
            for (int i = 1; i < nums.length; i++) {
                m = Math.max(m, nums[i]);
            }

            int exp = 1; // 1, 10, 100, 1000 ...
            int R = 10; // 10 digits

            int[] aux = new int[nums.length];

            while (m / exp > 0) { // Go through all digits from LSB to MSB
                int[] count = new int[R];

                for (int i = 0; i < nums.length; i++) {
                    count[(nums[i] / exp) % 10]++;
                }

                for (int i = 1; i < count.length; i++) {
                    count[i] += count[i - 1];
                }

                for (int i = nums.length - 1; i >= 0; i--) {
                    aux[--count[(nums[i] / exp) % 10]] = nums[i];
                }

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = aux[i];
                }
                exp *= 10;
            }

            int max = 0;
            for (int i = 1; i < aux.length; i++) {
                max = Math.max(max, aux[i] - aux[i - 1]);
            }

            return max;
        }
    }
}

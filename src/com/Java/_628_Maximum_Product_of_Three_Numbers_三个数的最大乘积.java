package src.com.Java;

/*
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
示例 1:
输入: [1,2,3]
输出: 6
示例 2:
输入: [1,2,3,4]
输出: 24
 */
public class _628_Maximum_Product_of_Three_Numbers_三个数的最大乘积 {
    class Solution {
        public int maximumProduct(int[] nums) {
            int Max1 = Integer.MIN_VALUE, Max2 = Integer.MIN_VALUE, Max3 = Integer.MIN_VALUE; // 前三个正数最大的
            int Min1 = Integer.MAX_VALUE, Min2 = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num > Max1) { // 比最大的要大
                    Max3 = Max2; // 反着赋值，省去了temp
                    Max2 = Max1;
                    Max1 = num;
                } else if (num > Max2) {
                    Max3 = Max2;
                    Max2 = num;
                } else if (num > Max3) {
                    Max3 = num;
                }
                if (num < Min1) { // 记录两个负数最小的
                    Min2 = Min1;
                    Min1 = num;
                } else if (num < Min2) {
                    Min2 = num;
                }
            }
            return Math.max(Max1 * Max2 * Max3, Max1 * Min1 * Min2); // 三个最大的，一个最大的两个最小的
        }
    }
}

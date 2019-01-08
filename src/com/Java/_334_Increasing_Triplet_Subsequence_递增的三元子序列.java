package src.com.Java;

/*
给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
数学表达式如下:
    如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
    使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
示例 1:
输入: [1,2,3,4,5]
输出: true
 */
public class _334_Increasing_Triplet_Subsequence_递增的三元子序列 {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3)
                return false;
            // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
            int small = Integer.MAX_VALUE;
            int big = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= small)
                    small = nums[i];// update small if n is smaller than both
                else if (nums[i] <= big)
                    big = nums[i];// update big only if greater than small but smaller than big
                else if (nums[i] >= big)
                    return true;// return if you find a number bigger than both
            }
            return false;
        }
    }
}

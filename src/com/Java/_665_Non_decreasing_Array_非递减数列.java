package src.com.Java;

/*
给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
示例 1:
输入: [4,2,3]
输出: True
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:
输入: [4,2,1]
输出: False
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */
public class _665_Non_decreasing_Array_非递减数列 {
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int cnt = 0;                                           //the number of changes
            for (int i = 1; i < nums.length && cnt <= 1; i++) {
                if (nums[i - 1] > nums[i]) {
                    cnt++;
                    if (i - 2 < 0 || nums[i - 2] <= nums[i])
                        nums[i - 1] = nums[i];                    //modify nums[i-1] of a priority
                    else nums[i] = nums[i - 1];                   //have to modify nums[i]
                }
            }
            return cnt <= 1;
        }
    }
}

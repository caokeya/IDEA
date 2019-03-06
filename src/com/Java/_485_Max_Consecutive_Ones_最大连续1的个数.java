package src.com.Java;

/*
给定一个二进制数组， 计算其中最大连续1的个数。
示例 1:
输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */
public class _485_Max_Consecutive_Ones_最大连续1的个数 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int count = 0;
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    temp++;
                    if (count < temp) {
                        count = temp;
                    }
                } else {
                    temp = 0;
                }
            }
            return count;
        }
    }
}

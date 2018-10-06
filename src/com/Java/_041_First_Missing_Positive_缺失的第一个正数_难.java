package src.com.Java;
/*
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
示例 1:
输入: [1,2,0]
输出: 3
示例 2:
输入: [3,4,-1,1]
输出: 2
 */
public class _041_First_Missing_Positive_缺失的第一个正数_难 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            return findMissing(nums, 1);
        }
        
        private int findMissing(int[] nums, int given) {
            int min = given;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == min) min++;
            }
            
            if (min != given) min = findMissing(nums, min);
            
            return min;
        }
    }
}

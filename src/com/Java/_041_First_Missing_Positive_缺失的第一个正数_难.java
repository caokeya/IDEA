package src.com.Java;

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

package src.com.Java;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
 */
public class _283_Mmove_Zeros_移动零元素 {
    class Solution {
        // Shift non-zero values as far forward as possible
        // Fill remaining space with zeros
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) return;

            int insertPos = 0;
            for (int num : nums) {
                if (num != 0) nums[insertPos++] = num;
            }

            while (insertPos < nums.length) {
                nums[insertPos++] = 0;
            }
        }
    }
}

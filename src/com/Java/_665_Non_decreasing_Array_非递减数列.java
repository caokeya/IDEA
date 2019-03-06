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
            boolean once = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (once) {
                        return false;
                    }
                    once = true;
                    if (i > 0 && nums[i - 1] > nums[i + 1]) {
                        // could be fixed with modifying nums[i+1] to nums[i]
                        nums[i + 1] = nums[i];
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean checkPossibility(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (i > 0) {
                        if (nums[i - 1] <= nums[i + 1])
                            nums[i] = nums[i - 1];
                        else
                            nums[i + 1] = nums[i];
                    }
                    count++;
                    if (count > 1)
                        return false;
                }
            }
            return true;
        }
    }
}

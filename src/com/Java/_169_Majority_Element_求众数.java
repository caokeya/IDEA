package src.com.Java;

/*
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class _169_Majority_Element_求众数 {
    class Solution {
        public int majorityElement(int[] nums) {
            int cnt = 1;
            int target = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    cnt++;
                } else {
                    cnt--;
                    if (cnt == 0) {
                        target = nums[i];
                        cnt++;
                    }
                }
            }
            return target;
        }
    }
}

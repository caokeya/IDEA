package src.com.Java;

import java.util.HashMap;
import java.util.Map;

//利用HashMap对两个数字进行求和得到与目标值相等的数字的位置
/*
给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class _001_Two_sum_Totarget_利用HashMap对两个数字进行求和得到与目标值相等的数字的位置 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            if (nums == null || nums.length < 2) {
                return res;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (map.containsKey(temp)) {
                    res[0] = map.get(temp);
                    res[1] = i;
                    return res;
                } else {
                    map.put(nums[i], i);
                }
            }
            return res;
        }
    }
}

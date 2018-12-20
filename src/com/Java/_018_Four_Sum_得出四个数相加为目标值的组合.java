package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//得出四个数相加为目标值的组合
/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class _018_Four_Sum_得出四个数相加为目标值的组合 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 4) return res;
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len - 3; i++) {
                if (i != 0 && nums[i] == nums[i - 1])
                    continue;
                for (int j = i + 1; j < len - 2; j++) {
                    if (j != i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int lo = j + 1, hi = len - 1;
                    while (lo < hi) {
                        int sum = nums[lo] + nums[hi] + nums[i] + nums[j];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[lo], nums[hi], nums[i], nums[j]));
                            lo++;
                            hi--;
                            while (lo < hi && nums[lo - 1] == nums[lo]) lo++;
                            while (lo < hi && nums[hi + 1] == nums[hi]) hi--;
                        } else if (sum > target) {
                            hi--;
                        } else {
                            lo++;
                        }
                    }
                }
            }
            return res;
        }
    }
}

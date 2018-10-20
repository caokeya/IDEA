package src.com.Java;

import java.util.Arrays;

/*
给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
示例 1:
输入: [2,2,3,4]
输出: 3
解释:
有效的组合是: 
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
 */
public class _611_Valid_Triangle_Number_有效三角形的个数 {
    class Solution {
        // Three Pointer like 3-sum
        // Time O(n^2) Space O(1)
        public int triangleNumber(int[] nums) {
            if (nums == null || nums.length < 3)
                return 0;
            Arrays.sort(nums);
            int result = 0;
            for (int i = nums.length - 1; i >= 2; i--)
                result += backtrack(nums, i);
            return result;
        }

        private int backtrack(int[] nums, int index) {
            int l = 0, r = index - 1;
            int result = 0;
            while (l < r) {
                if (nums[index] < nums[l] + nums[r]) {
                    result += r - l;
                    r--;
                } else {
                    l++;
                }
            }
            return result;
        }
    }
}

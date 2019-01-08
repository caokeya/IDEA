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
    public class Solution {
        public int triangleNumber(int[] nums) {
            int result = 0;
            if (nums.length < 3) return result;
            Arrays.sort(nums);
            for (int i = 2; i < nums.length; i++) {
                int left = 0, right = i - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > nums[i]) {
                        result += (right - left);
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return result;
        }
    }
}

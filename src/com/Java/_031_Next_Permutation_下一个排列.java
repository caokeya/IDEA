package src.com.Java;

import java.util.Arrays;
/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。
以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class _031_Next_Permutation_下一个排列 {
    class Solution {
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 2; i >= 0; i--) {
                // 寻找可以替换的最低位
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        // 确保替换位的后续位的值最小
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
                // 若当前位不可替换，则自当前位开始排序，以保证下一位可以在不进行完整遍历的前提下找到最小的更大值
                Arrays.sort(nums, i, nums.length);
            }
        }
    }
}

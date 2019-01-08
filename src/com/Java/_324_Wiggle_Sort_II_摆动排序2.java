package src.com.Java;

import java.util.Arrays;

/*
给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
示例 :
输入: nums = [1, 3, 2, 2, 3, 1]
输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 */
public class _324_Wiggle_Sort_II_摆动排序2 {
    class Solution {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            int[] arr = Arrays.copyOf(nums, nums.length);

            int j = nums.length - 1;
            for (int i = 1; i < nums.length; i += 2) {
                nums[i] = arr[j];
                --j;
            }
            for (int i = 0; i < nums.length; i += 2) {
                nums[i] = arr[j];
                --j;
            }
        }
    }

    class Solution2 {
        public void wiggleSort(int[] nums) {
            int[] temp = (int[]) nums.clone();
            Arrays.sort(temp);
            int n = nums.length;
            int left = (n - 1) / 2;
            int right = n - 1;

            int index = 0;
            while (left >= 0 && right >= (n + 1) / 2) {
                nums[index++] = temp[left--];
                nums[index++] = temp[right--];
            }
            if (left >= 0) {
                nums[index] = temp[left];
            }
        }
    }
}

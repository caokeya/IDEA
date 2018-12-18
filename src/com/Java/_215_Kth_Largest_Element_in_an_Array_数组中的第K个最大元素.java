package src.com.Java;

import java.util.Arrays;

/*
 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 示例 1:
 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:
 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
*/
public class _215_Kth_Largest_Element_in_an_Array_数组中的第K个最大元素 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            return quickSelect(nums, 0, nums.length - 1, k);
        }

        private int quickSelect(int[] nums, int start, int end, int k) {
            if (start == end) return nums[start];

            int left = start, right = end;
            int pivot = nums[(start + end) / 2];
            while (left <= right) {
                while (left <= right && nums[left] > pivot) left++;
                while (left <= right && nums[right] < pivot) right--;
                if (left <= right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                    right--;
                }
            }

            //这里right和left易错，分割完成后，right变成左边的右边界了。
            if (right - start + 1 >= k) {
                return quickSelect(nums, start, right, k);
            }

            //包含left小于等于k的情况就表示在右边了
            if (left - start + 1 <= k) {
                return quickSelect(nums, left, end, k - (left - start));
            }

            //当right和left中间有一个数且这个数就是第k大的时候，上面2个条件都会不满足
            return nums[right + 1];
        }

        class Solution2 {
            public int findKthLargest2(int[] nums, int k) {
                Arrays.sort(nums);
                return nums[nums.length - k];
            }
        }
    }
}

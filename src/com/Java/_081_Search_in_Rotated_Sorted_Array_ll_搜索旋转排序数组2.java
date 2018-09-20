package src.com.Java;

public class _081_Search_in_Rotated_Sorted_Array_ll_搜索旋转排序数组2 {
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[left] < nums[mid]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[left] > nums[mid]) {
                    if (nums[mid] <= target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    left++;
                }
            }
            return false;
        }
    }
}

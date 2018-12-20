package src.com.Java;

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
 */
public class _034_Find_First_and_Last_Position_of_Element_in_Sorted_Array_在排序数组中查找元素的第一个和最后一个位置 {
    class Solution {
        public int[] searchRange(int[] a, int t) {
            int i = 0;
            int j = a.length - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (a[mid] < t) {
                    i = mid + 1;
                } else if (a[mid] > t) {
                    j = mid - 1;
                } else {
                    int start = mid;
                    int end = mid;
                    while (start >= 0 && a[start] == t) {
                        start--;
                    }
                    while (end < a.length && a[end] == t) {
                        end++;
                    }
                    int[] res = new int[]{start + 1, end - 1};
                    return res;
                }
            }
            return new int[]{-1, -1};
        }
    }

    class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            if (nums.length == 0 || nums == null) {
                result[0] = -1;
                result[1] = -1;
                return result;
            }
            result[0] = left(nums, target);
            result[1] = right(nums, target);
            return result;
        }

        private int left(int[] nums, int target) {
            int index = -1;
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left < right) {
                mid = (right - left) / 2 + left;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (nums[left] == target) {
                index = left;
            }
            return index;
        }

        private int right(int[] nums, int target) {
            int index = -1;
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left < right) {
                mid = (right - left) / 2 + left + 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            if (nums[right] == target) {
                index = right;
            }
            return index;
        }
    }
}
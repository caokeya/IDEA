package src.com.Java;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
你可以假设数组中不存在重复元素。
 */
public class _153_Find_Minimum_in_Rotated_Sorted_Array_寻找旋转排序数组中的最小值 {
    public class Solution {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else if (nums[mid] > nums[r]) {
                    l = mid + 1;
                }
            }
            return nums[l];
        }
    }
}

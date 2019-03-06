package src.com.Java;

/*
给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
示例 1:
输入: [1,1,2,3,3,4,4,8,8]
输出: 2
示例 2:
输入: [3,3,7,7,10,11,11]
输出: 10
 */
public class _540_Single_Element_in_a_Sorted_Array_有序数组中的单一元素 {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (mid % 2 == 1)
                    mid--;
                if (nums[mid] != nums[mid + 1])
                    j = mid;
                else
                    i = mid + 2;
            }
            return nums[i];
        }
    }
}

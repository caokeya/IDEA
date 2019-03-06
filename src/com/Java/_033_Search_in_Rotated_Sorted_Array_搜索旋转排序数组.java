package src.com.Java;

import java.util.HashMap;
import java.util.Map;
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。
示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
 */
public class _033_Search_in_Rotated_Sorted_Array_搜索旋转排序数组 {
    class Solution {
        public int search(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    class SolutionMap {
        public int search(int[] nums, int target) {
            Map<Integer, Integer> m = new HashMap<>();

            if (nums.length == 0)
                return -1;

            for (int i = 0; i < nums.length; i++)
                m.put(nums[i], i);

            return (m.containsKey(target)) ? m.get(target) : -1;
        }
    }
}

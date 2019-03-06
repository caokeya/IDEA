package src.src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 示例 1:
 输入: nums = [1,2,3,1], k = 3
 输出: true
 示例 2:
 输入: nums = [1,0,1,1], k = 1
 输出: true
 示例 3:
 输入: nums = [1,2,3,1,2,3], k = 2
 输出: false
 */
public class _219_Contains_DuplicateII_存在重复元素2 {
    //Map
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums.length < 1)
                return false;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.containsKey(num)) {
                    if (i - map.get(num) <= k)
                        return true;
                }
                map.put(num, i);
            }
            return false;
        }
    }

    //Set
    class Solution2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (i > k) set.remove(nums[i - k - 1]);
                if (!set.add(nums[i]))
                    return true;
            }
            return false;
        }
    }
}

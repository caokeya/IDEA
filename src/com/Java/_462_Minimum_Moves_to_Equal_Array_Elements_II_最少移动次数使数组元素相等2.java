package src.com.Java;

import java.util.Arrays;

/*
给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
例如:
输入:
[1,2,3]
输出:
2
说明：
只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）： 
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class _462_Minimum_Moves_to_Equal_Array_Elements_II_最少移动次数使数组元素相等2 {
    public class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int i = 0, j = nums.length - 1;
            int count = 0;
            while (i < j) {
                count += nums[j] - nums[i];
                i++;
                j--;
            }
            return count;
        }
    }

}

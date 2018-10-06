package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
找到所有出现两次的元素。
示例：
输入:
[4,3,2,7,8,2,3,1]
输出:
[2,3]
 */
public class _442_Find_All_Duplicates_in_an_Array_数组中重复的数据 {
    public class Solution {
        // when find a number i, flip the number at position i-1 to negative.
        // if the number at position i-1 is already negative, i is the number that occurs twice.

        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0)
                    res.add(Math.abs(index + 1));
                nums[index] = -nums[index];
            }
            return res;
        }
    }
}

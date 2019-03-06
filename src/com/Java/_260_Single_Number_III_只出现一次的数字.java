package src.src.com.Java;

/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
示例 :
输入: [1,2,1,3,2,5]
输出: [3,5]
 */
public class _260_Single_Number_III_只出现一次的数字 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int res = 0;

            // xor of the two unique elements
            for (int i = 0; i < nums.length; i++) {
                res = res ^ nums[i];
            }

            //find the rightmost set bit of this result
            res &= -res;
            //res ^= res & (res - 1);

            int[] rets = {0, 0};
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & res) == 0) {
                    // xor all numbers who has this bit set
                    rets[0] ^= nums[i];
                } else {
                    // xor all numbers who has this bit unset
                    rets[1] ^= nums[i];
                }
            }
            return rets;
        }
    }
}

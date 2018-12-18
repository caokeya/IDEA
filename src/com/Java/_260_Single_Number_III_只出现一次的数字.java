package src.com.Java;

/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
示例 :
输入: [1,2,1,3,2,5]
输出: [3,5]
 */
public class _260_Single_Number_III_只出现一次的数字 {
    public class Solution {
        public int[] singleNumber(int[] nums) {
            // Pass 1 :
            // Get the XOR of the two numbers we need to find
            int diff = 0;
            for (int num : nums) {
                diff ^= num;
            }
            // Get its last set bit
            diff &= -diff;

            // Pass 2 :
            int[] rets = {0, 0}; // this array stores the two numbers we will return
            for (int num : nums) {
                if ((num & diff) == 0) // the bit is not set
                {
                    rets[0] ^= num;
                } else // the bit is set
                {
                    rets[1] ^= num;
                }
            }
            return rets;
        }
    }
}

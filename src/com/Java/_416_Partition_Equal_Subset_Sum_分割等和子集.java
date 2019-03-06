package src.com.Java;

/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
    每个数组中的元素不会超过 100
    数组的大小不会超过 200
示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class _416_Partition_Equal_Subset_Sum_分割等和子集 {
    public class Solution {
        public boolean canPartition(int[] nums) {
            // check edge case
            if (nums == null || nums.length == 0) {
                return true;
            }
            // preprocess
            int volumn = 0;
            for (int num : nums) {
                volumn += num;
            }
            if (volumn % 2 != 0) {
                return false;
            }
            volumn /= 2;
            // dp def
            boolean[] dp = new boolean[volumn + 1];
            // dp init
            dp[0] = true;
            // dp transition
            for (int i = 1; i <= nums.length; i++) {
                for (int j = volumn; j >= nums[i - 1]; j--) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
            return dp[volumn];
        }
    }
}

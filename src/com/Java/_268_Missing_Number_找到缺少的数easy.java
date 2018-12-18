package src.com.Java;

/*
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
示例 1:
输入: [3,0,1]
输出: 2
示例 2:
输入: [9,6,4,2,3,5,7,0,1]
输出: 8
 */
public class _268_Missing_Number_找到缺少的数easy {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    class Solution2 {
        public int missingNumber(int[] nums) {
            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            return n * (n + 1) / 2 - sum;
        }
    }
}

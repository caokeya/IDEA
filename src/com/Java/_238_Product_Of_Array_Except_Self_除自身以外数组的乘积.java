package src.com.Java;

/*
 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 示例:
 输入: [1,2,3,4]
 输出: [24,12,8,6]
*/
public class _238_Product_Of_Array_Except_Self_除自身以外数组的乘积 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] leftProduct = new int[n];
            int[] rightProduct = new int[n];
            int[] ans = new int[n];
            leftProduct[0] = 1;
            rightProduct[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
            }
            for (int i = 0; i < n; i++) {
                ans[i] = leftProduct[i] * rightProduct[i];
            }
            return ans;

        }
    }
}

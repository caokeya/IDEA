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
            int[] res = new int[nums.length];
            res[0] = 1; //left
            for (int i = 1; i < nums.length; i++) { // Storing all the products of the left elements
                res[i] = res[i - 1] * nums[i - 1];
            }
            int right = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                res[i] *= right; // Multiplying all the products of right elements
                right = right * nums[i];
            }
            return res;
        }
    }
}

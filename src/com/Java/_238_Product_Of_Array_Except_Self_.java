package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年10月15日 上午10:18:36 
* 类说明 
* 
Given an array nums of n integers where n > 1,  return an array output such that output[i] is 
equal to the product of all the elements of nums except nums[i].
Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).
Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space 
for the purpose of space complexity analysis.)

*/
public class _238_Product_Of_Array_Except_Self_ {

    public int[] productExceptSelf(int[] nums) {
     
    	int[] ans = new int[nums.length];
    	ans[0] = 1;
    	//先计算nums[i]左侧元素的乘积，存储在ans[i]中
    	for (int i = 1; i < nums.length; i++) {
			ans[i] = ans[i-1] * nums[i-1];
		}
    	int right = 1;
    	//再计算nums[i]右侧的元素乘积，并将左侧和右侧乘积相乘，就是所需要的结果
    	for (int i = nums.length -1; i >=0; i--) {
			ans[i] *= right;
			right *=nums[i];
			
		}
    	/*以上三句也可以写成：
		 * 
		 * for (int i = nums.length -2; i >=0; i--) {
			ans[i] *= ans[i+1]*right;
			right  *= nums[i+1];
		}
		 */
    	return ans;
    	
    	
    	
    }
}

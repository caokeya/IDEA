package src.com.Java;

/**
 * @author suzw
 * @version 创建时间：2018年10月26日 下午1:00:01 类说明 Given an array containing n distinct
 *          numbers taken from 0, 1, 2, ..., n, find the one that is missing
 *          from the array.
 * 
 *          Example 1:
 * 
 *          Input: [3,0,1] Output: 2 Example 2:
 * 
 *          Input: [9,6,4,2,3,5,7,0,1] Output: 8 Note: Your algorithm should run
 *          in linear runtime complexity. 
 *          Could you implement it using only
 *          constant extra space complexity?
 */
public class _268_Missing_Number_找到缺少的数easy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int i=0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
    
	public static int missingNumber2(int[] nums) {
		int[] newNums = new int[nums.length + 1];

		for (int i : nums) {
			newNums[i] = 1;
		}
		for (int i = 0; i < newNums.length; i++) {
			if (newNums[i] == 0)
				return i;
		}
		return 0;
	}
}

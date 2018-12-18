package src.com.Java;

/**
 * @author suzw
 * @version 创建时间：2018年10月30日 下午2:07:06 类说明 Given an array nums, write a function
 *          to move all 0's to the end of it while maintaining the relative
 *          order of the non-zero elements.
 * 
 *          Example:
 * 
 *          Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 *          You must do this in-place without making a copy of the array.
 *          Minimize the total number of operations.
 */
public class _283_Mmove_Zeros_移动零元素 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1ms，一次遍历，一直将非零元素前移，和零元素进行交换位置。
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = -1;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
	}

	// 改进：只用一个for循环
	public static void moveZeros(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int last = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[++last] = nums[i];
				if (i != last)
					nums[i] = 0;
			}
		}
	}

	public static void moveZerosBasic(int[] nums) {
		if (nums.length <= 1)
			return;

		int index = 0;
		for (int i : nums)
			if (i != 0)
				nums[index++] = i;

		while (index < nums.length)
			nums[index++] = 0;
		return;
	}
}

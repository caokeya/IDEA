package src.com.Java;

import java.util.Arrays;

/** 
* @author  suzw
* @version 创建时间：2018年9月12日 下午4:31:52 
* 类说明 
* Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class _215_Kth_Largest_Element_in_an_Array_排序 {

	public static void main(String[] args) {
		
		int[] nums= {3,2,1,5,6,4};
		int k =2;
		System.out.println(findKthLargest(nums, k));
	}
    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

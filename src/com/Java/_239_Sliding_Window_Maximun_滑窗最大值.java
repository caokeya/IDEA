package src.com.Java;

/** 
* @author  suzw
* @version 创建时间：2018年10月16日 上午10:44:46 
* 类说明 
* Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
Follow up:
Could you solve it in linear time?
*/
public class _239_Sliding_Window_Maximun_滑窗最大值 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		//不知道哪个傻子提交了 “空集合，K=0”的测试用例，leetcode还通过了
		  if(nums.length == 0) return new int[0];
        int[] ans = new int[nums.length-k+1];
        
        int[] left = nums.clone();
        int[] right = nums.clone();
        /*For Example: A = [2,1,3,4,6,3,8,9,10,12,56], w=4
         * 1.   partition the array in blocks of size w=4. The last block may have less then w.
				2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|
  */      
        
        for (int i = 1; i < nums.length; i++) {
        	/*
        	 * Traverse the list from start to end and calculate max_so_far. 
        	 * Reset max after each block boundary (of w elements).
				left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56
        	 */
			if (i % k != 0) 
				left[i] = Math.max(left[i-1], left[i]);
			int j = nums.length-i-1;
			/*
			 * Similarly calculate max in future by traversing from end to start.
				right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56
			 */
			if (j % k != 0)
				right[j] = Math.max(right[j+1], right[j]);
		}
        /*
         * now, sliding max at each position i in current window, sliding-max(i) = max{right_max(i), left_max(i+w-1)}
			sliding_max = 4, 6, 6, 8, 9, 10, 12, 56
         */
        for (int i = 0,j = 0; i+k <= right.length; i++,j++) {
			ans[j] = Math.max(left[i+k-1], right[j]);
		}
        
        return ans;
		
    }
}

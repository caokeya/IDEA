package src.com.Java;

import java.util.Arrays;

/** 
* @author  suzw
* @version 创建时间：2018年11月7日 下午5:07:18 
* 类说明 
* 1. https://leetcode.com/problems/longest-increasing-subsequence/discuss/152065/Python-explain-the-O(nlogn)-solution-step-by-step
* 2. https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
* 3. 在2 的下方，有二叉搜索的方法
* 
* 方法一： 暴力搜索，时间复杂度是2^n，放弃
* 方法二： DP，时间复杂度n^2，32ms左右
* 方法三：n*logn
* 	我们先建立一个数组 ends，把首元素放进去，然后比较之后的元素，

	如果遍历到的新元素比ends数组中的首元素小的话，替换首元素为此新元素，
	如果遍历到的新元素比ends数组中的末尾元素还大的话，将此新元素添加到ends数组末尾(注意不覆盖原末尾元素)。
	如果遍历到的新元素比ends数组首元素大，比尾元素小时，此时用二分查找法找到第一个不小于此新元素的位置，覆盖掉位置的原来的数字，
以此类推直至遍历完整个 nums 数组，此时 ends 数组的长度就是我们要求的 LIS 的长度，特别注意的是 ends 
数组的值可能不是一个真实的LIS，比如若输入数组nums为 {4, 2， 4， 5， 3， 7}，那么算完后的ends数组为
{2， 3， 5， 7}，可以发现它不是一个原数组的LIS，只是长度相等而已，千万要注意这点。

* 方法四： 使用二分查找优化，思路更清晰，n*logn，1ms
* 上面那种方法很类似，思路是先建立一个空的dp数组，然后开始遍历原数组，对于每一个遍历到的数字，
* 我们用二分查找法在dp数组找第一个不小于它的数字，如果这个数字不存在，那么直接在dp数组后面加上
* 遍历到的数字，如果存在，则将这个数字更新为当前遍历到的数字，最后返回dp数字的长度即可，注意的是，
* 跟上面的方法一样，特别注意的是dp数组的值可能不是一个真实的LIS。参见代码如下：
--------------------- 
作者：Inside_Zhang 
来源：CSDN 
原文：https://blog.csdn.net/lanchunhui/article/details/51611970 
版权声明：本文为博主原创文章，转载请附上博文链接！
* 
*/
public class _300_Longest_Increasing_Subsequence_最长上升子序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {1,3,2,4,5};
		int[] nums = {10,9,2,5,3,4};
		System.out.println(lengthOfLISBasicN2(nums));
	}
	/*
	 * Explain:
	 * tails is an array storing the smallest tail of all increasing subsequences with 
	 * length i+1 in tails[i].
	For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

	len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
	len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
	len = 3   :      [4, 5, 6]            => tails[2] = 6
	We can easily prove that tails is a increasing array. Therefore it is possible to
	 do a binary search in tails array to find the one needs update.
	
	Each time we only do one of the two:
	
	(1) if x is larger than all tails, append it, increase the size by 1
	(2) if tails[i-1] < x <= tails[i], update tails[i]
	Doing so will maintain the tails invariant. The the final answer is just the size.
	 */
	public int lengthOfLIS(int[] nums) {
	    int[] tails = new int[nums.length];
	    int size = 0;
	    for (int x : nums) {
	        int i = 0, j = size;
	        while (i != j) {
	            int m = (i + j) / 2;
	            if (tails[m] < x)
	                i = m + 1;
	            else
	                j = m;
	        }
	        tails[i] = x;
	        if (i == size) ++size;
	    }
	    return size;
	}
	// Runtime: 2 ms
	public int lengthOfLISByBinarySearch(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 0;i< dp.length;i++){
            int pos = binarySearchPosition(dp,nums[i],i);
            dp[pos] = nums[i];
        }
        for(int i = dp.length - 1;i >= 0;i--){
            if(dp[i] != Integer.MAX_VALUE) return i + 1;
        }
        return 0;
    }
    private int binarySearchPosition(int[] dp,int target,int hi){
        int low = 0;
        while(low <= hi){
            int mid = low + (hi - low)/2;
            if(target == dp[mid]) return mid;
            else if(target < dp[mid]) hi = mid - 1;
            else if(target > dp[mid]) low = mid + 1;
        }
        return low;
    }
    
    //使用 DP算法
    public  static int lengthOfLISBasicN2(int[] nums) {
    	int ans = 0;
    	int[] dp = new int[nums.length];
    	for (int i = 0;i<nums.length;i++) {
    		dp[i] = 1;	//初始化
			for (int j = 0 ;j<i;j++) 
				if (nums[j]< nums[i]) 
					dp[i] = Math.max(1 + dp[j], dp[i]);
			ans = Math.max(ans, dp[i]);
		}
    	
    	return ans;
    	
    }
}

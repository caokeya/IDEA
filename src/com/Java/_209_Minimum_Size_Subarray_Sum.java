package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年9月11日 上午11:09:10 
* 类说明 
*/
public class _209_Minimum_Size_Subarray_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		System.out.println(minSubArrayLen(11, nums));

	}
	public static int minSubArrayLen(int s ,int[] nums) {
		
		int sum = 0;
		int head = 0;
		int min =Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			for (; sum>=s; head++) {
				min = Math.min(min, i-head+1);
				sum -=nums[head];
			}
		}
		if (min ==Integer.MAX_VALUE) 	return 0;
		return min;
		//以下只选出相等的情况
		/*
		for (int i = 0; i < nums.length; i++) {
			if (sum+nums[i]>s) {
				System.out.println(nums[i]);
				sum =0 ;
				ans =0;
				i = head;
				head++;
			}
			else if (sum+nums[i] ==s) {
				
				ans++;
				System.out.println(nums[i]+"="+ans);
				if (min==0) {
					min = ans;
				}
				min = (min>ans)? ans:min;
				System.out.println("min:"+min);
				sum = 0;
				i = head ;
				head++;
			}
			else {
				System.out.print(nums[i]+"+");
				sum +=nums[i];
				ans++;
			}
		}
		return min;
		*/
		
		
		
	}

	
	
}

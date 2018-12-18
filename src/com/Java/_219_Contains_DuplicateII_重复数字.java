package src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 
* @author  suzw
* @version 创建时间：2018年9月13日 下午4:44:52 
* 类说明 
* Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/
public class _219_Contains_DuplicateII_重复数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,3,1};
		System.out.println(containsDuplicate2(nums, 3));

	}
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    
	 public static boolean containsDuplicate2(int[] nums,int k) {
	        Map<Integer, Integer> map = new HashMap<>();
	     
	        for (int i = 0;i<nums.length;i++) {
				if(map.containsKey(nums[i])) 
					if ((i-map.get(nums[i])<=k)) {
						return true;
				}
				map.put(nums[i], i);
			}
	    	
	    	return false;
	    }
}

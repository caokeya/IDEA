package src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 
* @author  suzw
* @version 创建时间：2018年9月13日 下午2:50:53 
* 类说明 
* Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
Example 1:
Input: [1,2,3,1]
Output: true
Example 2:
Input: [1,2,3,4]
Output: false
Example 3:
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
public class _217_Contains_Duplicate_存在重复元素 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
			if(!map.containsKey(i)) map.put(i, 1);
			else return true;
		}
    	
    	return false;
    }
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length<2) return false;
        for(int i=1; i<nums.length; i++)
        {
            for(int j=i-1; j>=0; j--)
            {
                if(nums[i]>nums[j]) break;
                if(nums[i]==nums[j]) return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate3(int[] nums) {
       Set<Integer> set = new HashSet<>();
        for (int i : nums) {
			if(!set.add(i)) 
				return true;
		}
    	
    	return false;
    }
}

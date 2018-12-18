package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  suzw
* @version 创建时间：2018年9月13日 下午12:54:32 
* 类说明 
* Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/
public class _216_Combination_Sum_III_组合求和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(3, 9));
	}
	
	
    public static List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> ret = new ArrayList<>();
    	
    	backTracking(ret, new ArrayList<>(), k, n, 1);
		return ret;
       
    }
	/*
	
	*@author: suzw
	*@date: 2018年9月13日下午2:25:33
	*@TODO
	*@param: k:组合的个数
	*@param: n:目标和
	*@position： 
	*/
	public static void backTracking(List<List<Integer>> ret,List<Integer> list,int k,int n,int position) {
		if(n<0 || list.size()>k) return;
		else if(n == 0 && list.size() == k) ret.add(new ArrayList<>(list));
		else {
				for(int i = position;i<10;i++) {
					list.add(i);
					backTracking(ret, list, k, n-i, i+1);
					list.remove(list.size()-1);
				}
			
		}
		
	}

}

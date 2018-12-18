package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年10月24日 下午2:09:07 
* 类说明 
* Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.
Note:

1 is typically treated as an ugly number.
Input is within the 32-bit signed integer range: [−231,  231 − 1].
*/
public class _263_Ugly_Number_只由235乘积构成的数 {

	public static void main(String[] args) {
		
		System.out.println(isUugly(6));
	}
	
	public static boolean isUugly(int num) {
		if(num == 0) return false;
		
		int[] nums= {2,3,5};
		for (int i : nums) {
			while(num%i == 0)
				num /=i;
		}
		
		if(num == 1 ) return true;
		else return false;
	}
}

package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年9月1日 上午10:46:15 
* 类说明 
* 
* Input: [5,7]
	Output: 4
*/
public class _201_Bitwise_AND_of_Numbers_Range_数字区间按位与 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 5;
		int n =7;
		System.out.println(rangeBitwiseAnd(m, n));
	}
	
	public static int rangeBitwiseAnd(int m,int n) {
		if (m ==0) {
			return 0;
		}
		int moveStep = 1;
		while(m!=n) {
			m >>=1;
			n>>=1;
			moveStep <<=1;
		}
		return m*moveStep;
		
	}

}

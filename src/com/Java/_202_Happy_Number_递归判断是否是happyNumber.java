package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年9月1日 上午11:33:36 
* 类说明 
* 
*/
public class _202_Happy_Number_递归判断是否是happyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(16));

	}
	
	public static boolean isHappy(int m) {
		int sum = 0;
		int quyu = 0;
		int times= 0;
		while(true) {
			sum=0;
			while(m!=0) {
				quyu=m%10;
				m/=10;
				System.out.println("yushu:"+quyu);
				sum +=quyu*quyu;
		}
			System.out.println("sum:"+sum);
		if (sum==1) 	return true;
		else m = sum;
		times++;
		if (times>10000) {
			return false;
			
		}
		}
		
	}
}

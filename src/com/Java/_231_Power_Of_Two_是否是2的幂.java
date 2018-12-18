package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年9月20日 下午3:18:47 
* 类说明 
*/
public class _231_Power_Of_Two_是否是2的幂 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo2(2));
		System.out.println(isPowerOfTwo2(3));
		System.out.println(isPowerOfTwo2(4));
		System.out.println(isPowerOfTwo2(5));
		System.out.println(isPowerOfTwo2(16));
		System.out.println(isPowerOfTwo2(17));
		
	}
//Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
	
	  public static boolean isPowerOfTwo(int n) {
		    if (n < 1) return false;
		    return (n & (n - 1)) == 0;
		  }
	  
    public static boolean isPowerOfTwo2(int n) {
//        if(n==1) return true;
//        if(n==0) return false;
//    	int temp = n;
//        while (temp%2==0) {
//			temp = temp/2;
//			
//		}
//        if (temp ==1) return true;
//        else return false;
        if(n <= 0) return false;
        while( n != 1) { // 没有得到最终结果
           
            if(n % 2 != 0) return false; 
             n = n/2;
        }
        return true;
    }
    
}

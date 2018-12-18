package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年10月22日 下午4:10:34 
* 类说明 
* 常见思路见第三种方法，但是效率低
* 
* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
*/
public class _258_Add_Digits_各位相加化简成一位数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(38));
	}
	
    public static int addDigits(int num) {
    	 return (num - 1) % 9 + 1;
    	/*
        if(num==0)
            return 0;
        else if(num%9==0)
            return 9;
        else
            return num%9;
            */
    }
    /*
     * 到20的所有的树根：
1    1
2    2
3    3
4    4
5    5
6    6
7    7
8    8    
9    9    
10    1
11    2
12    3    
13    4
14    5
15    6
16    7
17    8
18    9
19    1
20    2
根据上面的列举，我们可以得出规律，每9个一循环，所有大于9的数的树根都是对9取余，那么对于等于9的数对9取余就是0了，
为了得到其本身，而且同样也要对大于9的数适用，我们就用(n-1)%9+1这个表达式来包括所有的情况[n-1为了回避对是否是9的倍数的判断]
     */
    public int addDigits2(int num) {
        	 // return (num - 1) % 9 + 1;
             // until we get num to one digit
         while (num / 10 > 0) {
            // reintitialise sum on each loop
            int sum = 0;
            // increment sum by whatever is left over when you divide by 10 (last digit in num)
            // then divide number by 10 (because it an int we will discard the last number)
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
	   public static int addDigitsBak(int num) {
	       //int ans = 0;
	       
	       while(num>9) {
	    	   int[] numTo = intToSingleNum(num);
	    	   num = 0;
	    	   for (int i : numTo) {
				num +=i;
	    	   }
	       }
	       return num;
		   
	    }
	   public static int[] intToSingleNum(int num) {
		String numS = Integer.toString(num);
		int len = numS.length();
		int[] ans = new int[len];
		for (int i = 0; i < len; i++) {
			ans[i] = Integer.parseInt(String.valueOf(numS.charAt(i)));
		}
		return ans;
	}
}

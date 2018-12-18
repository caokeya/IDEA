package src.com.Java;

import java.util.Stack;

/** 
* @author  suzw
* @version 创建时间：2018年9月21日 上午9:07:52 
* 类说明 
* * Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
Example 1:
Input: "3+2*2"
Output: 7
Example 2:
Input: " 3/2 "
Output: 1
Example 3:
Input: " 3+5 / 2 "
Output: 5
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/
public class _227_Basic_CalculatorII_基础计算器 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String string = "3+2*2";
	System.out.println(calculate(string));
	}
	
    public static int calculate(String s) {
        int len =s.length();
        if (s==null || len == 0) return 0;
      
        int num = 0;
       	int ans = 0;
       	Stack<Integer> stack = new Stack<Integer>();
       	
        char sign ='+';
        char[] sChars= s.toCharArray();
        for (int i = 0; i < len; i++) {
			if(Character.isDigit(sChars[i])) {
				num = num*10 + sChars[i]-'0';
			}
			//找到运算符时，或者到结尾，与下一句的结果不同：
			//else if (' '!=sChars[i] || i==len -1) {
			if ((!Character.isDigit(sChars[i]) && ' '!=sChars[i] )|| i==len -1) {
				
				if (sign=='+') {
					stack.push(num);
					
				}else if (sign=='-') {
					stack.push(-num);
					
				}else if (sign=='*') {		
					stack.push(stack.pop()*num);
				}	
				else if (sign=='/') {
					stack.push(stack.pop()/num);
				}
				sign=sChars[i];
				num = 0;
			}
		}	
        for (int i : stack) {
        	ans +=i;
		}
        return ans;
    }
}

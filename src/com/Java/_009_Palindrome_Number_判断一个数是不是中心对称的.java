package src.com.Java;

//判断一个数是不是中心对称的
/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
示例 1:
输入: 121
输出: true
 */
public class _009_Palindrome_Number_判断一个数是不是中心对称的 {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            int val = 0;
            int n = x;
            while (n > 0) {
                val = val * 10 + n % 10;
                n = n / 10;
            }
            return val == x;
        }
    }
}

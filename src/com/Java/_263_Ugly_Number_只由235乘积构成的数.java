package src.com.Java;

/*
编写一个程序判断给定的数是否为丑数。
丑数就是只包含质因数 2, 3, 5 的正整数。
示例 1:
输入: 6
输出: true
解释: 6 = 2 × 3
示例 2:
输入: 8
输出: true
解释: 8 = 2 × 2 × 2
示例 3:
输入: 14
输出: false
解释: 14 不是丑数，因为它包含了另外一个质因数 7。
*/
public class _263_Ugly_Number_只由235乘积构成的数 {
    class Solution {
        public boolean isUgly(int num) {
            while (num > 1) {
                if (num % 2 == 0) num /= 2;
                else if (num % 3 == 0) num /= 3;
                else if (num % 5 == 0) num /= 5;
                else {
                    return false;
                }
            }
            return num == 1;
        }
    }
}

package src.src.com.Java;

/*
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
示例 1:
输入: 1
输出: true
解释: 2^0 = 1
示例 2:
输入: 16
输出: true
解释: 2^4 = 16
示例 3:
输入: 218
输出: false
*/
public class _231_Power_Of_Two_是否是2的幂 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            return (n & (n - 1)) == 0;
        }
    }

    class Solution2 {
        public boolean isPowerOfTwo(int n) {
            int c = 0;
            while (n > 0) {
                c += (n & 1);
                n = (n >> 1);
            }
            return c == 1;
        }
    }
}

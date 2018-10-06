package src.com.Java;

/*
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
说明：不要使用任何内置的库函数，如  sqrt。
示例 1：
输入：16
输出：True
 */
public class _367_Valid_Perfect_Square_有效的完全平方数 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            int low = 1, high = num;
            while (low <= high) {
                long mid = (low + high) >>> 1;
                if (mid * mid == num) {
                    return true;
                } else if (mid * mid < num) {
                    low = (int) mid + 1;
                } else {
                    high = (int) mid - 1;
                }
            }
            return false;
        }
    }
}

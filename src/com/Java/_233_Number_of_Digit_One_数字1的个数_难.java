package src.com.Java;

/*
 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 示例:
 输入: 13
 输出: 6
 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */
public class _233_Number_of_Digit_One_数字1的个数_难 {
    /*
    if n = xyzdabc
    we are considering the occurrence of one on thousand, it should be:
    (1) xyz * 1000                     if d == 0
    (2) xyz * 1000 + abc + 1           if d == 1
    (3) xyz * 1000 + 1000              if d >  1
     */
    class Solution {
        public int countDigitOne(int n) {
            if (n <= 0) return 0;
            int q = n, x = 1, ans = 0;
            do {
                int digit = q % 10;
                q /= 10;
                ans += q * x;
                if (digit == 1) ans += n % x + 1;
                if (digit > 1) ans += x;
                x *= 10;
            } while (q > 0);
            return ans;
        }
    }
}

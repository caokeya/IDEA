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
    case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
    case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次.
    case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次.
     */
    class Solution {
        int countDigitOne(int n) {
            if (n < 1) return 0;
            if (n >= 1 && n < 10) return 1;
            // x: first digit
            int y = 1, x = n;
            while (!(x < 10)) {
                x /= 10;
                y *= 10;
            }
            if (x == 1)
                return countDigitOne(y - 1) + n % y + 1 + countDigitOne(n % y);
            else
                return y + x * countDigitOne(y - 1) + countDigitOne(n % y);
        }
    }
}

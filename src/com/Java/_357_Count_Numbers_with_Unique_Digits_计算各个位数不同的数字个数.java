package src.com.Java;

/*
给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
示例:
输入: 2
输出: 91 
解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class _357_Count_Numbers_with_Unique_Digits_计算各个位数不同的数字个数 {
    class Solution {
        /*
        n为10的指数，输出区间内所有digit是unique的数字的数量
        n=1, f(1)=10
        n=2, f(2)=9*(10-1)
        n=3, f(3)=9*(10-1)*(10-2)
        n=4, f(2)=9*(10-1)*(10-2)*(10-3)
        ...
        除了个位数，最高位上都有9个选择，其他位数上的选择依次递减
        比方说，一个百位数，百位上有9个选择，十位上就有（10-1）个选择，因为要和百位数字不同，
        个位上只有（10-2）个数字，因为要和百位、十位数字都不同
        */
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            int availableDigit = 9;
            int res = 10;
            int uniqleDigit = 9;
            int i = 2;
            while (i <= n) {
                uniqleDigit *= availableDigit;
                res += uniqleDigit;
                i++;
                availableDigit--;
            }
            return res;
        }
    }
}

package src.com.Java;

/*
编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
示例 :
输入: 11
输出: 3
解释: 整数 11 的二进制表示为 00000000000000000000000000001011
 */
public class _191_Number_of_1_Bits_二进制1的个数 {
    public class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                count += (n >> i & 1) == 1 ? 1 : 0;
            }
            return count;
        }
    }
}

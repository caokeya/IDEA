package src.com.Java;

/*
颠倒给定的 32 位无符号整数的二进制位。
示例:
输入: 43261596
输出: 964176192
解释: 43261596 的二进制表示形式为 00000010100101000001111010011100 ，
返回  964176192，其二进制表示形式为 00111001011110000010100101000000 。
 */
public class _190_Reverse_Bits_颠倒二进制位 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result += n & 1;
                n >>>= 1; // CATCH: must do unsigned shift
                if (i < 31) // CATCH: for last digit, don't shift!
                    result <<= 1;
            }
            return result;
        }
    }
}

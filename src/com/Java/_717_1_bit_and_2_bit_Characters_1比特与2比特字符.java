package src.com.Java;

/*
有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
示例 1:
输入: 
bits = [1, 0, 0]
输出: True
解释: 
唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
示例 2:
输入: 
bits = [1, 1, 1, 0]
输出: False
解释: 
唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 */
public class _717_1_bit_and_2_bit_Characters_1比特与2比特字符 {
    /*
         如果数组中只有一个符号，答案总是正确的(因为最后一个元素是0)
         如果最后再出现两个0，不管剩下的符号是什么，答案都是正确的。1100…1000,)
         如果在最后一个元素之前有一个元素(…10)，那么结果取决于序列1的计数，即
        a)如果有1(10，…01110)答案是错误的，因为只有一个1没有配对
        b)如果是偶数(110，……011110)答案是正确的，因为最后的0没有任何匹配项
     */
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int ones = 0;
            // Starting from one but last, as last one is always 0.
            for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
                ones++;
            }
            if (ones % 2 > 0)
                return false;
            return true;
        }
    }
}

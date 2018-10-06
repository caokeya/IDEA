package src.com.Java;

/*
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
示例 1:
输入: 2
输出: [0,1,1]
 */
public class _338_Counting_Bits_比特位计数 {
    class Solution {
        public int[] countBits(int num) {
            int[] f = new int[num + 1];
            for (int i = 1; i <= num; i++)
                f[i] = f[i >> 1] + (i & 1);
            return f;
        }
    }
}

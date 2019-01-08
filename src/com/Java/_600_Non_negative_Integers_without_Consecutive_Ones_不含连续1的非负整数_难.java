package src.com.Java;

/*
给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
示例 1:
输入: 5
输出: 5
解释: 
下面是带有相应二进制表示的非负整数<= 5：
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 */
public class _600_Non_negative_Integers_without_Consecutive_Ones_不含连续1的非负整数_难 {
    public class Solution {
        /*
        one[i]为第i个有效位为1的非连续1解的个数;
        zero[i]为第i位有效位为0的非连续1解的个数;
        最棘手的部分是如何计算小于num的解。
        我们首先计算所有n位解的个数:res = 1 [n - 1] + 0 [n - 1]。
        然后减去大于num的解，迭代num的MSB到LSB:
        if bit[i] == 1
            if bit[i + 1] == 0, 在res中没有比num大的解，我们进一步研究更小的位并进行相减。
            if bit[i + 1] == 1, 我们知道在这些res解中它不会有任何连续的1。当位[i + 1] == 1时，在一个[i + 1]中，有效解的第i位必须是0，
                                这些都小于num，我们不需要检查较小的位并进行相减，因此我们打破了循环。
        if bit[i] == 0
            if bit[i + 1] == 1,在res中没有比num大的解，我们进一步研究更小的位并进行相减。
            if bit[i + 1] == 0,我们知道0 [i + 1]包括i-th == 0(00***)和i-th位== 1(01***)的解，我们知道num的i-th位是0，
                               所以我们需要减去所有的01***解，因为它比num大。
        */
        public int findIntegers(int num) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
            int n = sb.length();

            int zero[] = new int[n];
            int one[] = new int[n];
            zero[0] = one[0] = 1;
            for (int i = 1; i < n; i++) {
                zero[i] = zero[i - 1] + one[i - 1];
                one[i] = zero[i - 1];
            }

            int result = zero[n - 1] + one[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1')
                    break;
                if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0')
                    result -= one[i];
            }

            return result;
        }
    }

    class Solution2 {
        public int findIntegers(int num) {
            if (num < 2)
                return num + 1;
            String s = Integer.toBinaryString(num);
            int n = s.length();
            int[] f = new int[n];
            f[0] = 1;
            f[1] = 2;
            for (int i = 2; i < n; i++)
                f[i] = f[i - 1] + f[i - 2];
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    continue;
                res += f[n - 1 - i];
                if (i > 0 && s.charAt(i - 1) == '1')
                    return res;
            }
            return ++res;
        }
    }
}

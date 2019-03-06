package src.com.Java;

/*
如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
返回使 S 单调递增的最小翻转次数。
示例 1：
输入："00110"
输出：1
解释：我们翻转最后一位得到 00111.
示例 2：
输入："010110"
输出：2
解释：我们翻转得到 011111，或者是 000111。
示例 3：
输入："00011000"
输出：2
解释：我们翻转得到 00000000。
 */
public class _926_Flip_String_to_Monotone_Increasing_将字符串翻转到单调递增 {
    class Solution {
        public int minFlipsMonoIncr(String S) {
            int n = S.length();
            int leftOne = 0;
            int rightZero = 0;
            int res = 0;

            for (int i = 0; i < n; i++) {
                if (S.charAt(i) == '0')
                    rightZero++;
            }
            res = rightZero;
            for (int i = 0; i < n; i++) {
                if (S.charAt(i) == '0') {
                    rightZero -= 1;
                } else {
                    leftOne += 1;
                }
                res = Math.min(res, rightZero + leftOne);
            }
            return res;
        }
    }
}

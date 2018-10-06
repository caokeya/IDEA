package src.com.Java;

/*
把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 
注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
示例 1:
输入: "a"
输出: 1
解释: 字符串 S 中只有一个"a"子字符。
示例 2:
输入: "cac"
输出: 2
解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
示例 3:
输入: "zab"
输出: 6
解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
 */
public class _467_Unique_Substrings_in_Wraparound_String_环绕字符串中唯一的子字符串 {
    public class Solution {
        public int findSubstringInWraproundString(String p) {
            // count[i] is the maximum unique substring end with ith letter.
            // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
            int[] count = new int[26];

            // store longest contiguous substring ends at current position.
            int maxLengthCur = 0;

            for (int i = 0; i < p.length(); i++) {
                if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                    maxLengthCur++;
                } else {
                    maxLengthCur = 1;
                }

                int index = p.charAt(i) - 'a';
                count[index] = Math.max(count[index], maxLengthCur);
            }

            // Sum to get result
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += count[i];
            }
            return sum;
        }
    }
}

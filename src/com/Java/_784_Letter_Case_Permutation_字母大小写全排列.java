package src.com.Java;

import java.util.LinkedList;
import java.util.List;

/*
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
输入: S = "3z4"
输出: ["3z4", "3Z4"]
输入: S = "12345"
输出: ["12345"]
 */
public class _784_Letter_Case_Permutation_字母大小写全排列 {
    class Solution {
        public List<String> letterCasePermutation(String S) {
            if (S == null) {
                return new LinkedList<>();
            }

            List<String> res = new LinkedList<>();
            helper(S, res, 0);
            return res;
        }

        public void helper(String s, List<String> res, int pos) {
            if (pos == s.length()) {
                res.add(s);
                return;
            }
            if (s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
                helper(s, res, pos + 1);
                return;
            }

            char[] chs = s.toCharArray();
            chs[pos] = Character.toLowerCase(chs[pos]);
            helper(String.valueOf(chs), res, pos + 1);

            chs[pos] = Character.toUpperCase(chs[pos]);
            helper(String.valueOf(chs), res, pos + 1);
        }
    }
}

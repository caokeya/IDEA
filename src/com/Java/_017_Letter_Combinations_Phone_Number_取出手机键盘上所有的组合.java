package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//取出手机键盘上所有的组合
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
public class _017_Letter_Combinations_Phone_Number_取出手机键盘上所有的组合 {
    public class Solution {
        public List<String> letterCombinations(String digits) {
            LinkedList<String> ans = new LinkedList<String>();
            if (digits.isEmpty())
                return ans;
            String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ans.add("");
            for (int i = 0; i < digits.length(); i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                while (ans.peek().length() == i) {
                    String t = ans.remove();
                    for (char s : mapping[x].toCharArray())
                        ans.add(t + s);
                }
            }
            return ans;
        }
    }

    class Solution2 {
        private final char[][] chars = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        public List<String> letterCombinations(String digits) {
            List<String> l = new ArrayList();
            if (digits == null || digits.length() == 0) return l;
            StringBuilder sb = new StringBuilder();
            dfs(digits, sb, 0, digits.length(), l);
            return l;
        }

        private void dfs(String digits, StringBuilder sb, int k, int len, List<String> l) {
            if (k == len) {
                l.add(sb.toString());
                return;
            }
            int d = digits.charAt(k) - '0';
            for (int i = 0; i < chars[d].length; i++) {
                sb.append(chars[d][i]);
                dfs(digits, sb, k + 1, len, l);
                sb.deleteCharAt(k);
            }
        }
    }
}

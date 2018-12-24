package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class _131_Palindrome_Partitioning_分割回文串 {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            int m = (s == null) ? 0 : s.length();
            if (m == 0) {
                result.add(Arrays.asList(""));
                return result;
            }
            helper(s, 0, new ArrayList<>(), result);
            return result;
        }

        private void helper(String s, int current, List<String> cur, List<List<String>> result) {
            int m = s.length();
            if (current == m) {
                result.add(new ArrayList<>(cur));
                return;
            }
            for (int i = current + 1; i <= m; ++i) {
                String prefix = s.substring(current, i);
                if (check(prefix)) {
                    cur.add(prefix);
                    helper(s, i, cur, result);
                    cur.remove(cur.size() - 1);
                }
            }
        }

        private boolean check(String s) {
            int m = (s == null) ? 0 : s.length();
            if (m < 2) {
                return true;
            }
            int left = 0;
            int right = m - 1;
            while (left < right) {
                char lc = s.charAt(left++);
                char rc = s.charAt(right--);
                if (lc != rc) {
                    return false;
                }
            }
            return true;
        }
    }
}

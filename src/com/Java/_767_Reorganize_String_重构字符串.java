package src.com.Java;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
若可行，输出任意可行的结果。若不可行，返回空字符串。
示例 1:
输入: S = "aab"
输出: "aba"
示例 2:
输入: S = "aaab"
输出: ""
 */
public class _767_Reorganize_String_重构字符串 {
    class Solution {
        public String reorganizeString(String S) {
            int[] freq = new int[26];
            for (char c : S.toCharArray()) {
                freq[c - 'a']++;
            }

            int maxFreq = 0;
            char maxFreqC = 'a';
            for (int i = 0; i < 26; i++) {
                if (maxFreq < freq[i]) {
                    maxFreq = freq[i];
                    maxFreqC = (char) ('a' + i);
                }
            }

            // aba
            // 2 > (3 + 1) / 2
            if (maxFreq * 2 > (S.length() + 1))
                return "";

            int n = S.length();

            char[] a = new char[n];
            int i = 0;
            while (freq[maxFreqC - 'a']-- > 0) {
                a[i] = maxFreqC;
                i += 2;
            }

            for (char c = 'a'; c <= 'z'; c++) {
                while (freq[c - 'a']-- > 0) {
                    if (i >= n) {
                        i = 1;
                    }
                    a[i] = c;
                    i += 2;
                }
            }
            return new String(a);
        }
    }

    class Solution2 {
        // 总体思路是，先定义一个结果数组arr[]，将S中的相同元素隔开放入arr中即可
        // 特殊情况是当某个字符的个数多于(n + 1)/2个时，不可能使结果中相邻元素不同
        public String reorganizeString(String S) {
            int[] counts = new int[26];
            for (char c : S.toCharArray()) {
                counts[c - 'a']++;
            }

            int n = S.length();
            for (int count : counts) {
                if (count > (n + 1) / 2) {
                    return "";
                }
            }

            Character[] sChars = new Character[n];
            for (int i = 0; i < S.length(); i++) {
                sChars[i] = S.charAt(i);
            }
            Arrays.sort(sChars, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if (counts[o1 - 'a'] == counts[o2 - 'a']) {
                        return o1 - o2;
                    } else {
                        return counts[o2 - 'a'] - counts[o1 - 'a'];
                    }
                }
            });

            char[] ans = new char[n];
            int t = 0;
            for (char c : sChars) {
                ans[t] = c;
                t += 2;
                if (t >= n) {
                    t = 1;
                }
            }

            return String.valueOf(ans);
        }
    }
}

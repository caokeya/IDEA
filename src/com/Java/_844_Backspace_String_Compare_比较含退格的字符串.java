package com.Java;

/*
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
示例 1：
输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
示例 2：
输入：S = "ab##", T = "c#d#"
输出：true
解释：S 和 T 都会变成 “”。
示例 3：
输入：S = "a##c", T = "#a#c"
输出：true
解释：S 和 T 都会变成 “c”。
示例 4：
输入：S = "a#c", T = "b"
输出：false
解释：S 会变成 “c”，但 T 仍然是 “b”。
 */
public class _844_Backspace_String_Compare_比较含退格的字符串 {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            int i = S.length() - 1, j = T.length() - 1;
            int skipS = 0, skipT = 0;

            while (i >= 0 || j >= 0) {
                while (i >= 0) {
                    if (S.charAt(i) == '#') {
                        skipS++;
                        i--;
                    } else if (skipS > 0) {
                        skipS--;
                        i--;
                    } else {
                        break;
                    }
                }
                while (j >= 0) {
                    if (T.charAt(j) == '#') {
                        skipT++;
                        j--;
                    } else if (skipT > 0) {
                        skipT--;
                        j--;
                    } else {
                        break;
                    }
                }
                if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                    return false;
                }
                if ((i >= 0) != (j >= 0)) {
                    return false;
                }
                i--;
                j--;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean backspaceCompare(String S, String T) {
            StringBuilder sb = new StringBuilder();
            StringBuilder tb = new StringBuilder();

            for (int i = 0; i < S.length(); i++) {
                char s = S.charAt(i);
                if (s != '#') {
                    sb.append(s);
                } else {
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }

            for (int i = 0; i < T.length(); i++) {
                char t = T.charAt(i);
                if (t != '#') {
                    tb.append(t);
                } else {
                    if (tb.length() > 0) {
                        tb.deleteCharAt(tb.length() - 1);
                    }
                }
            }
            return sb.toString().equals(tb.toString());
        }
    }
}

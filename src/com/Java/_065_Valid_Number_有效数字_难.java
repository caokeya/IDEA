package src.com.Java;

/*
验证给定的字符串是否为数字。
例如:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
 */
public class _065_Valid_Number_有效数字_难 {
    class Solution {
        public boolean isNumber(String s) {
            boolean isE = false;
            boolean isDot = false;
            boolean isDigit = false;
            s = s.trim();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'e') {
                    if (!isDigit || isE) return false;
                    isDigit = false;
                    isE = true;
                } else if (c == '+' || c == '-') {
                    if (i != 0 && s.charAt(i - 1) != 'e') return false;
                } else if (c == '.') {
                    if (isE || isDot) return false;
                    isDot = true;
                } else if (Character.isDigit(c)) {
                    isDigit = true;
                } else {
                    return false;
                }
            }
            return s.length() > 0 && isDigit;
        }
    }
}

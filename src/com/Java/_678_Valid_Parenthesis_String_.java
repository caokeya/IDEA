package src.com.Java;

/*
给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
    任何左括号 ( 必须有相应的右括号 )。
    任何右括号 ) 必须有相应的左括号 ( 。
    左括号 ( 必须在对应的右括号之前 )。
    * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
    一个空字符串也被视为有效字符串。
示例 1:
输入: "()"
输出: True
示例 2:
输入: "(*)"
输出: True
示例 3:
输入: "(*))"
输出: True
 */
public class _678_Valid_Parenthesis_String_ {
    class Solution {
        public boolean checkValidString(String s) {
            int low = 0;
            int high = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    low++;
                    high++;
                } else if (s.charAt(i) == ')') {
                    if (low > 0) {
                        low--;
                    }
                    high--;
                } else {
                    if (low > 0) {
                        low--;
                    }
                    high++;
                }
                if (high < 0) {
                    return false;
                }
            }
            return low == 0;
        }
    }
}

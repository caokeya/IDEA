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
    /*
    low : take '*' as ')', if there are some '(' not matched
    high : take '*' as '('
    if high < 0 means too much ')'
    if low > 0 , after the count finished, means too much '('
    since low take '*' as ')', there might be too much ')', so that low might less than 0.
    That's why low-- should happen only low>0. This can thought as, low only take as much as '(''s ')' and ignore other ')' s.
    This will not cause problem since :
    '*' can be treated as empty
    high has deal with the situation that too much ')' exist
     */
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

    class Solution2 {
        public boolean checkValidString(String s) {
            int bal = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '*') bal++;
                else if (bal-- == 0) return false;
            }
            if (bal == 0) return true;
            bal = 0;
            for (int i = s.length()-1; i >= 0; i--) {
                if (s.charAt(i) == ')' || s.charAt(i) == '*') bal++;
                else if (bal-- == 0) return false;
            }
            return true;
        }
    }
}

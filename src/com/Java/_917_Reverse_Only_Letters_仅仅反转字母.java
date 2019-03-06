package src.com.Java;

/*
给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
示例 1：
输入："ab-cd"
输出："dc-ba"
示例 2：
输入："a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"
示例 3：
输入："Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"
 */
public class _917_Reverse_Only_Letters_仅仅反转字母 {
    class Solution {
        public String reverseOnlyLetters(String S) {
            StringBuilder sb = new StringBuilder(S);
            for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
                while (i < j && !Character.isLetter(sb.charAt(i)))
                    ++i;
                while (i < j && !Character.isLetter(sb.charAt(j)))
                    --j;
                sb.setCharAt(i, S.charAt(j));
                sb.setCharAt(j, S.charAt(i));
            }
            return sb.toString();
        }
    }
}

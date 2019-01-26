package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
示例 1：
输入： A = "ab", B = "ba"
输出： true
示例 2：
输入： A = "ab", B = "ab"
输出： false
示例 3:
输入： A = "aa", B = "aa"
输出： true
示例 4：
输入： A = "aaaaaaabc", B = "aaaaaaacb"
输出： true
示例 5：
输入： A = "", B = "aa"
输出： false
 */
public class _859_Buddy_Strings_亲密字符串 {
    class Solution {
        public boolean buddyStrings(String A, String B) {
            int lenA = A.length(), lenB = B.length();
            if (lenA != lenB)
                return false;
            if (A.equals(B)) {
                //count appearances of chars, has to >= 2
                int[] count = new int[26];
                for (char c : A.toCharArray())
                    count[c - 'a']++;
                for (int i : count)
                    if (i >= 2)
                        return true;
                return false;
            }

            //a, b not equals, if and only if they have to chars difference
            int first = -1, second = -1;
            for (int i = 0; i < lenA; i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }
            return second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first);
        }
    }
}

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
            if (A == null || B == null || A.length() != B.length())
                return false;
            if (A.equals(B))
                return hasDup(A);
            int a = -1;
            int b = -1;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (a < 0)
                        a = i;
                    else if (b < 0)
                        b = i;
                    else
                        return false;
                }
            }
            if (a < 0 || b < 0)
                return false;
            return A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a);
        }

        private boolean hasDup(String S) {
            Set<Character> set = new HashSet<Character>();
            for (char c : S.toCharArray()) {
                if (!set.add(c))
                    return true;
            }
            return false;
        }
    }
}

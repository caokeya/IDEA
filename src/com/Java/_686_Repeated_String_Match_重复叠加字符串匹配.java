package src.com.Java;

/*
给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
举个例子，A = "abcd"，B = "cdabcdab"。
答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 */
public class _686_Repeated_String_Match_重复叠加字符串匹配 {
    class Solution {
        public int repeatedStringMatch(String A, String B) {
            if (B.length() == 0 || A.length() == 0)
                return -1;
            int c = 0;
            StringBuilder sb = new StringBuilder();
            while (sb.length() < B.length()) {
                c++;
                sb.append(A);
            }
            if (sb.toString().lastIndexOf(B) != -1)
                return c;
            if (sb.append(A).toString().lastIndexOf(B) != -1)
                return c + 1;
            return -1;
        }
    }
}

package src.com.Java;

/*
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1
 */
public class _028_Implement_strStr_找到字符串出现的第一个位置 {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.equals("") || needle.equals(haystack)) {
                return 0;
            }
            if (haystack.equals("")) {
                return -1;
            }
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }
    }

    class Solution2 {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }
}

package com.Java;

/*
给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。
如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
示例:
输入: s = "abcdefg", k = 2
输出: "bacdfeg"
 */
public class _541_Reverse_String_II_反转字符串2 {
    public class Solution {
        public String reverseStr(String s, int k) {
            char[] arr = s.toCharArray();
            int n = arr.length;
            int i = 0;
            while (i < n) {
                int j = Math.min(i + k - 1, n - 1);
                swap(arr, i, j);
                i += 2 * k;
            }
            return String.valueOf(arr);
        }

        private void swap(char[] arr, int l, int r) {
            while (l < r) {
                char temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
            }
        }
    }
}

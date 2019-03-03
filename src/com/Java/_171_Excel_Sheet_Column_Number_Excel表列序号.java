package com.Java;
/*
给定一个Excel表格中的列名称，返回其相应的列序号。
例如，
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
 */
public class _171_Excel_Sheet_Column_Number_Excel表列序号 {
    class Solution {
        public int titleToNumber(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                result = result * 26 + (s.charAt(i) - 'A' + 1);
            }
            return result;
        }
    }
}

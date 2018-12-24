package src.com.Java;

/*
给定一个正整数，返回它在 Excel 表中相对应的列名称。
例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
 */
public class _168_Excel_Sheet_Column_Title_Excel表列名称 {
    class Solution {
        public String convertToTitle(int n) {
            String res = "";
            while(n != 0) {
                char ch = (char)((n - 1) % 26 + 65);
                n = (n - 1) / 26;
                res = ch + res;
            }
            return res;
        }
    }
}

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
    public class Solution {
        public String convertToTitle(int n) {
            StringBuilder result = new StringBuilder();

            while (n > 0) {
                n--;
                result.insert(0, (char) ('A' + n % 26));
                n /= 26;
            }

            return result.toString();
        }
    }
}

package src.com.Java;

/*
给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
注意:
    输入只包含小写英文字母。
    输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
    输入字符串的长度小于 50,000。
示例 1:
输入: "owoztneoer"
输出: "012" (zero one two)
示例 2:
输入: "fviefuro"
输出: "45" (four five)
 */
public class _423_Reconstruct_Original_Digits_from_English_从英文中重建数字 {
    class Solution {
        public String originalDigits(String s) {
            int[] count = new int[10];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'z') count[0]++;//z e r o
                if (c == 'w') count[2]++;//t w o
                if (c == 'x') count[6]++;//s i x
                if (c == 's') count[7]++;//s e v e n 7-6
                if (c == 'g') count[8]++;//e i g h t
                if (c == 'u') count[4]++;//f o u r
                if (c == 'f') count[5]++;//f i v e 5-4
                if (c == 'h') count[3]++;//t h r e e 3-8
                if (c == 'i') count[9]++;//n i n e 9-8-5-6
                if (c == 'o') count[1]++;//o n e 1-0-2-4
            }
            count[7] -= count[6];//s
            count[5] -= count[4];//f
            count[3] -= count[8];//h
            count[9] = count[9] - count[8] - count[5] - count[6];//i
            count[1] = count[1] - count[0] - count[2] - count[4];//o
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append(i);
                }
            }
            return sb.toString();
        }
    }
}

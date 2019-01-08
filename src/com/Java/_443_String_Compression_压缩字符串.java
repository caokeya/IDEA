package src.com.Java;

/*
给定一组字符，使用原地算法将其压缩。
压缩后的长度必须始终小于或等于原数组长度。
数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
在完成原地修改输入数组后，返回数组的新长度。
示例 1：
输入：
["a","a","b","b","c","c","c"]
输出：
返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
说明：
"aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 */
public class _443_String_Compression_压缩字符串 {
    class Solution {
        public int compress(char[] chars) {
            int indexAns = 0, index = 0;
            while (index < chars.length) {
                char currentChar = chars[index];
                int count = 0;
                while (index < chars.length && chars[index] == currentChar) {
                    index++;
                    count++;
                }
                chars[indexAns++] = currentChar;
                if (count != 1)
                    for (char c : Integer.toString(count).toCharArray())
                        chars[indexAns++] = c;
            }
            return indexAns;
        }
    }
}

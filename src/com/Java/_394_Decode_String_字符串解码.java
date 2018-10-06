package src.com.Java;

import java.util.Stack;

/*
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
示例:
s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
 */
public class _394_Decode_String_字符串解码 {
    public class Solution {
        public String decodeString(String s) {
            Stack<Integer> count = new Stack<>();
            Stack<String> result = new Stack<>();
            int i = 0;
            result.push("");
            while (i < s.length()) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    int start = i;
                    while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                        i++;
                    count.push(Integer.parseInt(s.substring(start, i + 1)));
                } else if (ch == '[') {
                    result.push("");
                } else if (ch == ']') {
                    String str = result.pop();
                    StringBuilder sb = new StringBuilder();
                    int times = count.pop();
                    for (int j = 0; j < times; j += 1) {
                        sb.append(str);
                    }
                    result.push(result.pop() + sb.toString());
                } else {
                    result.push(result.pop() + ch);
                }
                i += 1;
            }
            return result.pop();
        }
    }
}

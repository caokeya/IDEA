package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。
此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
示例 1:
输入: "(123)"
输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
示例 2:
输入: "(00011)"
输出:  ["(0.001, 1)", "(0, 0.011)"]
解释: 
0.0, 00, 0001 或 00.01 是不被允许的。
示例 3:
输入: "(0123)"
输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
示例 4:
输入: "(100)"
输出: [(10, 0)]
解释: 
1.0 是不被允许的。
 */
public class _816_Ambiguous_Coordinates_模糊坐标 {
    /*
    if S == "": return []
    if S == "0": return [S]
    if S == "0XXX0": return []
    if S == "0XXX": return ["0.XXX"]
    if S == "XXX0": return [S]
    return [S, "X.XXX", "XX.XX", "XXX.X"...]
     */
    class Solution {
        public List<String> ambiguousCoordinates(String S) {
            // 思路:
            // (1)对string的每个位置都分成两份处理
            // (2) parse()主要是解决invalid的情况，这些情况总结起来有3种：
            //     a. 开头和结尾都是0，0***0，如果string 长度是1的话，直接将“0”加入res中返回，否则返回空
            //     b. 开头是0，0***，则只能将开头的0独立开来，然后加小数点，再加上剩余部分构成一个新的string，将string加到res中
            //     c. 如果结尾是0, ***0, 则只将整个string加入res中
            // (3) 其余valid，只要将每位都加上小数点即可
            List<String> res = new ArrayList<String>();
            S = S.substring(1, S.length() - 1);

            for (int i = 1; i < S.length(); i++) {
                List<String> left = parse(S.substring(0, i));
                List<String> right = parse(S.substring(i));
                for (String leftPart : left) {
                    for (String rightPart : right) {
                        res.add("(" + leftPart + ", " + rightPart + ")");
                    }
                }
            }
            return res;
        }

        public List<String> parse(String s) {
            char[] letters = s.toCharArray();
            int len = s.length();
            List<String> res = new ArrayList<String>();
            if (letters[0] == '0' && letters[len - 1] == '0') {// "0xxxx0" Invalid unless a single "0"
                if (len == 1) {
                    res.add("0");
                }
                return res;
            }
            if (letters[0] == '0') {// "0xxxxx" The only valid result is "0.xxxxx"
                res.add("0." + s.substring(1));
                return res;
            }
            if (letters[len - 1] == '0') {// "xxxxx0" The only valid result is itself
                res.add(s);
                return res;
            }
            res.add(s);// Add itself
            for (int i = 1; i < len; i++) {// "xxxx" -> "x.xxx", "xx.xx", "xxx.x"
                res.add(s.substring(0, i) + "." + s.substring(i));
            }
            return res;
        }
    }
}

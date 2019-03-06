package src.src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
示例 1:
输入: "2-1-1"
输出: [0, 2]
解释:
((2-1)-1) = 0
(2-(1-1)) = 2
示例 2:
输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
*/
public class _241_Different_Ways_To_Add_Parentheses_运算表达式的不同组合结果 {
    class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            int len = input.length();
            List<Integer> left, right, res = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                char c = input.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    left = diffWaysToCompute(input.substring(0, i));
                    right = diffWaysToCompute(input.substring(i + 1, len));
                    for (Integer l : left) {
                        for (Integer r : right) {
                            if (c == '+') {
                                res.add(l + r);
                            } else if (c == '-') {
                                res.add(l - r);
                            } else {
                                res.add(l * r);
                            }

                        }
                    }
                }
            }
            if (res.size() == 0)
                res.add(Integer.valueOf(input));
            return res;
        }
    }
}


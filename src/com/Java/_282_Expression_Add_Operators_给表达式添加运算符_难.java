package src.src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
示例 1:
输入: num = "123", target = 6
输出: ["1+2+3", "1*2*3"]
示例 2:
输入: num = "232", target = 8
输出: ["2*3+2", "2+3*2"]
示例 3:
输入: num = "105", target = 5
输出: ["1*0+5","10-5"]
示例 4:
输入: num = "00", target = 0
输出: ["0+0", "0-0", "0*0"]
示例 5:
输入: num = "3456237490", target = 9191
输出: []
 */
public class _282_Expression_Add_Operators_给表达式添加运算符_难 {
    class Solution {
        //思路: DFS after each digit, we can try adding opeartors between each possible numbers.
        // When we reach to the last digit and the computation result is equal to the target, we add the path to the result list.
        //Time: O(3^(n-1)), n represents the length of the string, Space: O(n-1) if not considering the result list?
        public List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            if (num == null || num.length() == 0) return res;
            helper(res, "", num, target, 0, 0, 0);
            return res;
        }

        //最后一个multed是记录上一层将要进行乘法的数字
        public void helper(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
            //base case: when reaching the last character in the string
            if (pos == num.length()) {
                if (target == eval) res.add(path);
                return;
            }
            for (int i = pos; i < num.length(); i++) {
                // 0 cannot appear at the first digit of the any non-zero number,if so, cannot use this path
                if (num.charAt(pos) == '0' && i != pos) break;
                //find the number from string pos to i
                long cur = Long.parseLong(num.substring(pos, i + 1));
                //for the first number, just add it to the sum
                if (pos == 0) {
                    helper(res, path + cur, num, target, i + 1, cur, cur);
                }
                //try adding different operators with the number, make sure to store the number for multiplication next time
                else {
                    helper(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                    helper(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                    helper(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
                }
            }
        }
    }
}

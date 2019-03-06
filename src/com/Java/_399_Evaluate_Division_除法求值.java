package src.com.Java;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
示例 :
给定 a / b = 2.0, b / c = 3.0
问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]

输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries
(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，
即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。

基于上述例子，输入如下：
equations(方程式) = [ ["a", "b"], ["b", "c"] ],
values(方程式结果) = [2.0, 3.0],
queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 */
public class _399_Evaluate_Division_除法求值 {
    class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
            double[] result = new double[query.length];
            // filter unexpected words
            // 过滤掉没有遇见过的字符
            Set<String> words = new HashSet<>();
            for (String[] strs : equations) {
                words.add(strs[0]);
                words.add(strs[1]);
            }
            for (int i = 0; i < query.length; ++i) {
                String[] keys = query[i];
                if (!words.contains(keys[0]) || !words.contains(keys[1]))
                    result[i] = -1.0d;
                else {
                    Stack<Integer> stack = new Stack<>();
                    result[i] = helper(equations, values, keys, stack);
                }
            }
            return result;
        }

        public double helper(String[][] equations, double[] values, String[] keys, Stack<Integer> stack) {
            // 直接查找，key的顺序有正反
            // look up equations directly
            for (int i = 0; i < equations.length; ++i) {
                if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1]))
                    return values[i];
                if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0]))
                    return 1 / values[i];
            }
            // lookup equations by other equations
            // 间接查找，key的顺序也有正反
            for (int i = 0; i < equations.length; ++i) {
                if (!stack.contains(i) && keys[0].equals(equations[i][0])) {
                    stack.push(i);
                    double temp = values[i]
                            * helper(equations, values, new String[] { equations[i][1], keys[1] }, stack);
                    if (temp > 0)
                        return temp;
                    else
                        stack.pop();
                }
                if (!stack.contains(i) && keys[0].equals(equations[i][1])) {
                    stack.push(i);
                    double temp = helper(equations, values, new String[] { equations[i][0], keys[1] }, stack)
                            / values[i];
                    if (temp > 0)
                        return temp;
                    else
                        stack.pop();
                }
            }
            // 查不到，返回-1
            return -1.0d;
        }
    }
}

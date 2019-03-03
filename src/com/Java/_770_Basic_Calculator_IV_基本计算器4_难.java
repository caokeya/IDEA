package com.Java;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
给定一个表达式 expression 如 expression = "e + 8 - a + 5" 和一个求值映射，
如 {"e": 1}（给定的形式为 evalvars = ["e"] 和 evalints = [1]），返回表示简化表达式的标记列表，例如 ["-1*a","14"]
    表达式交替使用块和符号，每个块和符号之间有一个空格。
    块要么是括号中的表达式，要么是变量，要么是非负整数。
    块是括号中的表达式，变量或非负整数。
    变量是一个由小写字母组成的字符串（不包括数字）。请注意，变量可以是多个字母，并注意变量从不具有像 "2x" 或 "-x" 这样的前导系数或一元运算符 。
表达式按通常顺序进行求值：先是括号，然后求乘法，再计算加法和减法。例如，expression = "1 + 2 * 3" 的答案是 ["7"]。
输出格式如下：
    对于系数非零的每个自变量项，我们按字典排序的顺序将自变量写在一个项中。例如，我们永远不会写像 “b*a*c” 这样的项，只写 “a*b*c”。
    项的次数等于被乘的自变量的数目，并计算重复项。(例如，"a*a*b*c" 的次数为 4。)。我们先写出答案的最大次数项，用字典顺序打破关系，此时忽略词的前导系数。
    项的前导系数直接放在左边，用星号将它与变量分隔开(如果存在的话)。前导系数 1 仍然要打印出来。
    格式良好的一个示例答案是 ["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a", "5*c", "-6"] 。
    系数为 0 的项（包括常数项）不包括在内。例如，“0” 的表达式输出为 []。
示例：
输入：expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
输出：["-1*a","14"]
输入：expression = "e - 8 + temperature - pressure",
evalvars = ["e", "temperature"], evalints = [1, 12]
输出：["-1*pressure","5"]
输入：expression = "(e + 8) * (e - 8)", evalvars = [], evalints = []
输出：["1*e*e","-64"]
输入：expression = "7 - 7", evalvars = [], evalints = []
输出：[]
输入：expression = "a * b * c + b * a * c * 4", evalvars = [], evalints = []
输出：["5*a*b*c"]
输入：expression = "((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))",
evalvars = [], evalints = []
输出：["-1*a*a*b*b","2*a*a*b*c","-1*a*a*c*c","1*a*b*b*b","-1*a*b*b*c","-1*a*b*c*c","1*a*c*c*c","-1*b*b*b*c","2*b*b*c*c","-1*b*c*c*c",
      "2*a*a*b","-2*a*a*c","-2*a*b*b","2*a*c*c","1*b*b*b","-1*b*b*c","1*b*c*c","-1*c*c*c","-1*a*a","1*a*b","1*a*c","-1*b*c"]
 */
public class _770_Basic_Calculator_IV_基本计算器4_难 {
    class Solution {
        // 2*a*b
        class Term implements Comparable<Term> {
            int coef = 1;
            List<String> vars = new LinkedList<>();

            public Term(int n) {
                coef = n;
            }

            public Term(String s) {
                vars.add(s);
            }

            public String varString() {
                Collections.sort(vars);
                return vars.isEmpty() ? "" : ("*" + String.join("*", vars));
            }

            public String toString() {
                return coef + varString();
            }

            public boolean equals(Term t) {
                return varString().equals(t.varString());
            }

            public int compareTo(Term t) {
                return (vars.size() == t.vars.size()) ? varString().compareTo(t.varString())
                        : t.vars.size() - vars.size();
            }

            public Term multi(Term t) {
                Term res = new Term(coef * t.coef);
                res.vars.addAll(vars);
                res.vars.addAll(t.vars);
                return res;
            }
        }

        // 2*a*b-c*d
        class Sequence {
            List<Term> terms = new LinkedList<>();

            public Sequence() {
            }

            public Sequence(int n) {
                terms.add(new Term(n));
            }

            public Sequence(String s) {
                terms.add(new Term(s));
            }

            public Sequence(Term t) {
                terms.add(t);
            }

            public Sequence add(Sequence sq) {
                for (Term t2 : sq.terms) {
                    if (t2.coef == 0)
                        continue;
                    boolean found = false;
                    for (Term t1 : terms) {
                        if (t1.equals(t2)) {
                            t1.coef += t2.coef;
                            if (t1.coef == 0)
                                terms.remove(t1);
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        terms.add(t2);
                }
                return this;
            }

            public Sequence multi(Sequence sq) {
                Sequence res = new Sequence();
                for (Term t1 : terms)
                    for (Term t2 : sq.terms)
                        res.add(new Sequence(t1.multi(t2)));
                return res;
            }
        }

        public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
            List<String> res = new LinkedList<>();
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < evalvars.length; i++)
                map.put(evalvars[i], evalints[i]);
            Sequence sq = helper(expression, map);
            Collections.sort(sq.terms);
            for (Term t : sq.terms)
                if (!t.toString().equals("0"))
                    res.add(t.toString());
            return res;
        }

        int idx = 0;

        public Sequence helper(String e, Map<String, Integer> map) {
            Stack<Sequence> stack = new Stack<>();
            int flag = 1;
            while (idx < e.length()) {
                char c = e.charAt(idx++);
                if (c == ' ')
                    continue;
                else if (c == '(') {
                    Sequence sq = helper(e, map);
                    addToStack(stack, sq, flag);
                } else if (c == ')')
                    break;
                else if (c == '+' || c == '-' || c == '*')
                    flag = c == '+' ? 1 : c == '-' ? -1 : 0;
                else if (Character.isDigit(c)) {
                    int coef = c - '0';
                    while (idx < e.length() && Character.isDigit(e.charAt(idx)))
                        coef = coef * 10 + e.charAt(idx++) - '0';
                    addToStack(stack, new Sequence(coef), flag);
                } else if (Character.isLetter(c)) {
                    StringBuilder sb = new StringBuilder(c + "");
                    while (idx < e.length() && Character.isLetter(e.charAt(idx)))
                        sb.append(e.charAt(idx++));
                    String var = sb.toString();
                    if (map.containsKey(var))
                        addToStack(stack, new Sequence(map.get(var)), flag);
                    else
                        addToStack(stack, new Sequence(var), flag);
                }
            }
            Sequence res = new Sequence();
            while (!stack.isEmpty())
                res.add(stack.pop());
            return res;
        }

        public void addToStack(Stack<Sequence> stack, Sequence sq, int flag) {
            if (flag == 0)
                stack.add(stack.pop().multi(sq));
            else
                stack.add(sq.multi(new Sequence(flag)));
        }
    }
}

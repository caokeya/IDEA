package src.com.Java;

import java.util.*;

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
    项的次数等于被乘的自变量的数目，并计算重复项。(例如，"a*a*b*c" 的次数为 4。)。
    我们先写出答案的最大次数项，用字典顺序打破关系，此时忽略词的前导系数。
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
        public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
            System.out.println(expression.length());
            Map<String, Integer> eval = new HashMap<>();
            for (int i = 0; i < evalvars.length; i++)
                eval.put(evalvars[i], evalints[i]);
            char[] ch = expression.toCharArray();
            Map<String, Integer> map = helper(ch, eval);
            Map<String, Integer> formalMap = new HashMap<>();
            for (String str : map.keySet()) {
                if (!str.equals("1")) {
                    String[] strs = str.split("\\*");
                    Arrays.sort(strs);
                    StringBuilder sb = new StringBuilder();
                    for (String s : strs)
                        sb.append('*').append(s);
                    String lexicoKey = sb.substring(1);
                    formalMap.put(lexicoKey, formalMap.getOrDefault(lexicoKey, 0) + map.get(str));
                    if (formalMap.get(lexicoKey) == 0)
                        formalMap.remove(lexicoKey);
                }
            }
            List<String> keyList = new LinkedList<>();
            for (String str : formalMap.keySet())
                keyList.add(str);
            Collections.sort(keyList, new Comparator<String>() {
                public int compare(String str1, String str2) {
                    String[] s1 = str1.split("\\*");
                    String[] s2 = str2.split("\\*");
                    if (s1.length != s2.length) {
                        return s2.length - s1.length;
                    } else {
                        return str1.compareTo(str2);
                    }
                }
            });
            List<String> res = new LinkedList<>();
            for (String str : keyList)
                res.add(formalMap.get(str) + "*" + str);
            if (map.containsKey("1") && map.get("1") != 0)
                res.add(map.get("1") + "");
            return res;
        }

        int index = 0;

        public Map<String, Integer> helper(char[] ch, Map<String, Integer> eval) {
            Map<String, Integer>[] stack = new Map[ch.length];
            int stackIndex = 0;
            char op = '+';
            StringBuilder sb = new StringBuilder();
            boolean isNum = false;
            Map<String, Integer> term = null;
            while (index <= ch.length) {
                if (index != ch.length && ch[index] >= '0' && ch[index] <= '9') {
                    isNum = true;
                    sb.append(ch[index]);
                } else if (index != ch.length && ch[index] >= 'a' && ch[index] <= 'z') {
                    isNum = false;
                    sb.append(ch[index]);
                } else if (index == ch.length || ch[index] != ' ' && ch[index] != '(') {
                    if (term == null) {
                        term = new HashMap<>();
                        if (isNum) {
                            int value = Integer.valueOf(sb.toString());
                            term.put("1", value);
                        } else {
                            if (eval.containsKey(sb.toString())) {
                                int value = eval.get(sb.toString());
                                term.put("1", value);
                            } else {
                                term.put(sb.toString(), 1);
                            }
                        }
                    }
                    if (op != '*') {
                        if (op == '-') {
                            for (String str : term.keySet())
                                term.put(str, -1 * term.get(str));
                        }
                        stack[stackIndex++] = term;
                    } else {
                        stack[stackIndex - 1] = mul(stack[stackIndex - 1], term);
                    }
                    if (index == ch.length || ch[index] == ')')
                        break;
                    op = ch[index];
                    term = null;
                    sb.setLength(0);
                } else if (ch[index] == '(') {
                    index++;
                    term = helper(ch, eval);
                }
                index++;
            }
            Map<String, Integer> res = new HashMap<>();
            while (stackIndex != 0) {
                stackIndex--;
                Map<String, Integer> addTerm = stack[stackIndex];
                for (String str : addTerm.keySet()) {
                    res.put(str, res.getOrDefault(str, 0) + addTerm.get(str));
                    if (res.get(str) == 0)
                        res.remove(str);
                }
            }
            return res;
        }

        public Map<String, Integer> mul(Map<String, Integer> map1, Map<String, Integer> map2) {
            Map<String, Integer> res = new HashMap<>();
            for (String str1 : map1.keySet()) {
                int v1 = map1.get(str1);
                for (String str2 : map2.keySet()) {
                    int v2 = map2.get(str2);
                    String key;
                    if (str1.equals("1")) {
                        key = str2;
                    } else if (str2.equals("1")) {
                        key = str1;
                    } else {
                        key = str1 + "*" + str2;
                    }
                    res.put(key, res.getOrDefault(key, 0) + v1 * v2);
                    if (res.get(key) == 0)
                        res.remove(key);
                }
            }
            return res;
        }
    }
}

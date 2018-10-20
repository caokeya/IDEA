package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个类似 Lisp 语句的表达式 expression，求出其计算结果。
表达式语法如下所示:
    表达式可以为整数，let 语法，add 语法，mult 语法。表达式的结果总是一个整数。
    (整数可以是正整数、负整数、0)
    let 语法表示为 (let v1 e1 v2 e2 ... vn en expr), 其中 let语法总是以字符串 "let"来表示，接下来会跟随一个或多个交替变量或表达式，
                                      也就是说，第一个变量 v1被分配为表达式 e1 的值，第二个变量 v2 被分配为表达式 e2 的值，以此类推；最终 let 语法的值为 expr表达式的值。
    add语法表示为 (add e1 e2)，其中 add 语法总是以字符串 "add"来表示，该语法总是有两个表达式e1、e2, 该语法的最终结果是 e1 表达式的值与 e2 表达式的值之和。
    mult语法表示为 (mult e1 e2) ，其中 mult 语法总是以字符串"mult"表示， 该语法总是有两个表达式 e1、e2，该语法的最终结果是 e1 表达式的值与 e2 表达式的值之积。
    在该题目中，变量的命名以小写字符开始，之后跟随0个或多个小写字符或数字。为了方便，"add"，"let"，"mult"会被定义为"关键字"，不会在表达式的变量命名中出现。
    最后，要说一下范围的概念。在做计算时，需要注意优先级，在最内层(根据括号)的表达式的值应该先计算,然后依次计算外层的表达式。
    我们将保证每一个测试的表达式都是合法的。有关范围的更多详细信息，请参阅示例。
示例:
输入: (add 1 2)
输出: 3
输入: (mult 3 (add 2 3))
输出: 15
输入: (let x 2 (mult x 5))
输出: 10
输入: (let x 2 (mult x (let x 3 y 4 (add x y))))
输出: 14
解释: 
表达式 (add x y), 在获取 x 值时, 我们应当由最内层依次向外计算, 首先遇到了 x=3, 所以此处的 x 值是 3.
输入: (let x 3 x 2 x)
输出: 2
解释: let 语句中的赋值运算按顺序处理即可
输入: (let x 1 y 2 x (add x y) (add x y))
输出: 5
解释: 
第一个 (add x y) 计算结果是 3，并且将此值赋给了 x 。
第二个 (add x y) 计算结果就是 3+2 = 5 。
输入: (let x 2 (add (let x 3 (let x 4 x)) x))
输出: 6
解释: 
(let x 4 x) 中的 x 的作用范围仅在()之内。所以最终做加法操作时，x 的值是 2 。
输入: (let a1 3 b2 (add a1 1) b2) 
输出: 4
解释: 
变量命名时可以在第一个小写字母后跟随数字.
 */
public class _736_Parse_Lisp_Expression_Lisp_语法解析_难 {
    /*
    1）如果表达式是变量，那么我们就在变量表中查找到变量的名称，并且返回；如果表达式是值，则我们直接返回值。
    2）对于let而言，我们首先获得变量的名称，然后解析其对应的表达式，最后将变量的值和变量名的对应加入到表中。
                   例如对于(let x (add 2 3) x)，我们首先得到变量名x，然后解析表达式(add 2, 3)，得到值5，然后赋值x = 5。
                   对于最后一个x，我们在解析的过程中，直接在映射表中找到其对应的值5，并返回。
    3）对于add而言，我们首先解析第一个表达式，然后解析第二个表达式，最后将两者相加，并返回。
                   例如对于"(add (add 2 3) (add 3 4))"而言，第一个表达式是“(add 2 3)”，第二个表达式是"(add 3 4)"，解析后我们分别得到5和7.所以最后返回12 = 5 + 7即可。
    4）对于mult而言，我们解析的方式类似于add。
     */
    class Solution {
        public int evaluate(String expression) {
            return eval(expression, new HashMap<String, Integer>());
        }

        private int eval(String exp, Map<String, Integer> parent) {
            if (exp.charAt(0) != '(') {
                if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
                    return Integer.valueOf(exp);
                }
                return parent.get(exp);
            }

            Map<String, Integer> map = new HashMap<>();
            map.putAll(parent);
            List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
            if (exp.startsWith("(a")) {
                return eval(tokens.get(0), map) + eval(tokens.get(1), map);
            } else if (exp.startsWith("(m")) {
                return eval(tokens.get(0), map) * eval(tokens.get(1), map);
            } else {
                for (int i = 0; i < tokens.size() - 2; i += 2) {
                    map.put(tokens.get(i), eval(tokens.get(i + 1), map));
                }
                return eval(tokens.get(tokens.size() - 1), map);
            }
        }

        private List<String> parse(String input) {
            int p = 0;
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    p++;
                }

                if (c == ')') {
                    p--;
                }

                if (p == 0 && c == ' ') {
                    res.add(new String(sb));
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            }

            if (sb.length() > 0) {
                res.add(new String(sb));
            }

            return res;
        }
    }
}

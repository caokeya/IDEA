package src.com.Java;

/*
求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
如果方程没有解，请返回“No solution”。
如果方程有无限解，则返回“Infinite solutions”。
如果方程中只有一个解，要保证返回值 x 是一个整数。
示例 1：
输入: "x+5-3+x=6+x-2"
输出: "x=2"
示例 2:
输入: "x=x"
输出: "Infinite solutions"
示例 3:
输入: "2x=x"
输出: "x=0"
示例 4:
输入: "2x+3x-6x=x+2"
输出: "x=-1"
示例 5:
输入: "x=x+2"
输出: "No solution"
 */
public class _640_Solve_the_Equation_求解方程 {
    class Solution {
        public String solveEquation(String equation) {
            int[] res = evaluateExpression(equation.split("=")[0]), res2 = evaluateExpression(equation.split("=")[1]);
            res[0] = res[0] - res2[0];
            res[1] = res2[1] - res[1];
            if (res[0] == 0 && res[1] == 0)
                return "Infinite solutions";
            if (res[0] == 0)
                return "No solution";
            return "x=" + res[1] / res[0];
        }

        public int[] evaluateExpression(String exp) {
            String[] tokens = exp.split("(?=[-+])");//从-+向前找
            int[] res = new int[2];
            for (String token : tokens) {
                if (token.equals("+x") || token.equals("x"))
                    res[0] += 1;
                else if (token.equals("-x"))
                    res[0] -= 1;
                else if (token.contains("x"))
                    res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
                else
                    res[1] += Integer.parseInt(token);
            }
            return res;
        }
    }
}

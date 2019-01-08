package src.com.Java;

/*
给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 
如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
示例 1:
输入:"-1/2+1/2"
输出: "0/1"
 示例 2:
输入:"-1/2+1/2+1/3"
输出: "1/3"
示例 3:
输入:"1/3-1/2"
输出: "-1/6"
示例 4:
输入:"5/3+1/3"
输出: "2/1"
 */
public class _592_Fraction_Addition_and_Subtraction_分数加减运算 {
    class Solution {
        public String fractionAddition(String expression) {
            if (expression == null || expression.length() == 0)
                return "0/1";

            // 处理String
            expression = expression.replaceAll("\\-", "\\+-");
            String[] numbers = expression.split("\\+");

            String result = "0/1";
            for (String number : numbers) {
                if (number.length() > 1)
                    result = addNumber(result, number);
            }
            return result;
        }

        public String addNumber(String s1, String s2) {

            String[] sa1 = s1.split("/");
            String[] sa2 = s2.split("/");
            int n1 = Integer.parseInt(sa1[0]);
            int d1 = Integer.parseInt(sa1[1]);
            int n2 = Integer.parseInt(sa2[0]);
            int d2 = Integer.parseInt(sa2[1]);

            int n = n1 * d2 + n2 * d1;
            int d = d1 * d2;

            if (n == 0)
                return "0/1";
            boolean isNegative = (n * d < 0);
            n = Math.abs(n);
            d = Math.abs(d);
            int gcd = getGCD(n, d);
            if (isNegative)
                return "-" + (n / gcd) + "/" + (d / gcd);
            else
                return (n / gcd) + "/" + (d / gcd);
        }

        public int getGCD(int n, int d) {
            if (n < d) {// 确保n > d
                int temp = d;
                d = n;
                n = temp;
            }
            if (n % d == 0)
                return d;
            else
                return getGCD(d, n % d);
        }
    }
}

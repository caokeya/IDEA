package src.com.Java;

/*
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"
 */
public class _043_Multiply_Strings_字符串相乘 {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
                return "";
            if ("0".equals(num1) || "0".equals(num2))
                return "0";
            int[] res = new int[num1.length() + num2.length()];
            for (int i = num1.length() - 1; i >= 0; i--) {
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int sum = mul + res[i + j + 1];
                    res[i + j] += sum / 10;
                    res[i + j + 1] = sum % 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (sb.length() != 0 || res[i] != 0) sb.append(res[i]);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}

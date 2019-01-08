package src.com.Java;

/*
给定两个表示复数的字符串。
返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
示例 1:
输入: "1+1i", "1+1i"
输出: "0+2i"
解释: (1 + i) * (1 + i) = 1 + i^2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
示例 2:
输入: "1+-1i", "1+-1i"
输出: "0+-2i"
解释: (1 - i) * (1 - i) = 1 + i^2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
 */
public class _537_Complex_Number_Multiplication_复数乘法 {
    class Solution {
        public String complexNumberMultiply(String a, String b) {
            String ca[] = a.split("\\+");
            String cb[] = b.split("\\+");
            String caa[] = ca[1].split("i");
            String cbb[] = cb[1].split("i");

            int lefta = Integer.parseInt(ca[0]);
            int leftb = Integer.parseInt(cb[0]);
            int righta = Integer.parseInt(caa[0]);
            int rightb = Integer.parseInt(cbb[0]);
            int temp = lefta * leftb - (righta * rightb);
            int temp1 = (lefta * rightb) + (leftb * righta);
            String s = temp + "+" + temp1 + "i";
            return s;
        }
    }
}

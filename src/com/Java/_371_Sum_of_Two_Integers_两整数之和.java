package src.com.Java;

/*
不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
示例 1:
输入: a = 1, b = 2
输出: 3
 */
public class _371_Sum_of_Two_Integers_两整数之和 {
    // Iterative
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        /*
        a = 0001  b = 0011

        carry = a & b = 0001
        a = a ^ b = 0010
        b = carry << 1 = 0010

        carry = a & b = 0010
        a = a ^ b = 0000
        b = carry << 1 = 0100

        carry = a & b = 0000
        a = a ^ b = 0100
        b = carry << 1 =0000

        carry = a & b 得到进位位置
        a = a ^ b 得到正常相加
        b = carry << 1 向前进位
        */
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    // Iterative
    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }
}

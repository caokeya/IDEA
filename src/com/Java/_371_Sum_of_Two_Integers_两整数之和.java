package com.Java;

/*
不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
示例 1:
输入: a = 1, b = 2
输出: 3
 */
public class _371_Sum_of_Two_Integers_两整数之和 {
    public class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int c = ((a & b) << 1);
                a ^= b;
                b = c;
            }
            return a;
        }
    }

}

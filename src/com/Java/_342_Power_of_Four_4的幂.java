package com.Java;

/*
给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
示例 1:
输入: 16
输出: true
 */
public class _342_Power_of_Four_4的幂 {
    public class Solution {
        public boolean isPowerOfFour(int num) {
            return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
        }
    }

}

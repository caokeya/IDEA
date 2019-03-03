package com.Java;

/*
给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
示例 1:
输入: 5
输出: True
解释:
5的二进制数是: 101
示例 2:
输入: 7
输出: False
解释:
7的二进制数是: 111
示例 3:
输入: 11
输出: False
解释:
11的二进制数是: 1011
 示例 4:
输入: 10
输出: True
解释:
10的二进制数是: 1010
 */
public class _693_Binary_Number_with_Alternating_Bits_交替位二进制数 {
    class Solution {
        public boolean hasAlternatingBits(int n) {
            int bit = n & 1;
            n >>= 1;
            while (n > 0) {
                if ((n & 1) != (bit == 1 ? 0 : 1)) {
                    return false;
                }
                bit = n & 1;
                n >>= 1;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean hasAlternatingBits(int n) {
            String s = Integer.toBinaryString(n);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1))
                    return false;
            }
            return true;
        }
    }
   
    class Solution3 {
        public boolean hasAlternatingBits(int n) { 
            /*
            n =         1 0 1 0 1 0 1 0
            n >> 1      0 1 0 1 0 1 0 1
            n ^ n>>1    1 1 1 1 1 1 1 1
            n           1 1 1 1 1 1 1 1
            n + 1     1 0 0 0 0 0 0 0 0
            n & (n+1)   0 0 0 0 0 0 0 0
            */
            n = n ^ (n >> 1);
            return (n & n + 1) == 0;
        }
    }
}

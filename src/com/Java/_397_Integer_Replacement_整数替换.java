package src.com.Java;
/*
给定一个正整数 n，你可以做如下操作：
1. 如果 n 是偶数，则用 n / 2替换 n。
2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
n 变为 1 所需的最小替换次数是多少？
111011 -> 111010 -> 11101 -> 11100 -> 1110 -> 111 -> 1000 -> 100 -> 10 -> 1
111011 -> 111100 -> 11110 -> 1111 -> 10000 -> 1000 -> 100 -> 10 -> 1

 */
public class _397_Integer_Replacement_整数替换 {
    class Solution {
        public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {//最后一位是0
                n >>>= 1;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {//最后一位是1，但是倒数第二位是0就-1
                --n;
            } else {//最后一位是1，但是倒数第二位是1就+1
                ++n;
            }
            ++count;
        }
        return count;
        }
    }
}

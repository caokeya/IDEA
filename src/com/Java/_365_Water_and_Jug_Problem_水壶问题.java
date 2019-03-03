package com.Java;

/*
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
你允许：
    装满任意一个水壶
    清空任意一个水壶
    从一个水壶向另外一个水壶倒水，直到装满或者倒空
示例 1: (From the famous "Die Hard" example)
输入: x = 3, y = 5, z = 4
输出: True
 */
public class _365_Water_and_Jug_Problem_水壶问题 {
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            return (z == 0) || (((long) x + y >= z) && (z % gcd(x, y) == 0));
        }

        // greatest common divider.
        public int gcd(int x, int y) {
            // if x % y == 0, then y is the divider of x.
            return y == 0 ? x : gcd(y, x % y);
        }
    }
}

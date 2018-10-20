package src.com.Java;

/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
示例1:
输入: 5
输出: True
解释: 1 * 1 + 2 * 2 = 5
示例2:
输入: 3
输出: False
 */
public class _633_Sum_of_Square_Numbers_平方数之和 {
    public class Solution {
        public boolean judgeSquareSum(int c) {
            if (c < 0) {
                return false;
            }
            int left = 0, right = (int) Math.sqrt(c);
            while (left <= right) {
                int cur = left * left + right * right;
                if (cur < c) {
                    left++;
                } else if (cur > c) {
                    right--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}

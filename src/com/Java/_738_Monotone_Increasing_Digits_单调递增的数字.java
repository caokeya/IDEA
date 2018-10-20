package src.com.Java;

/*
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
示例 1:
输入: N = 10
输出: 9
示例 2:
输入: N = 1234
输出: 1234
示例 3:
输入: N = 332
输出: 299
 */
public class _738_Monotone_Increasing_Digits_单调递增的数字 {
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            char[] array = String.valueOf(N).toCharArray();
            int mark = -1;
            for (int i = array.length - 1; i >= 1; i--) {
                if (array[i] < array[i - 1]) {
                    array[i - 1]--;
                    mark = i;
                }

            }
            if (mark != -1) {
                for (int j = mark; j < array.length; j++) {
                    array[j] = '9';
                }
            }

            return Integer.valueOf(new String(array));
        }
    }
}

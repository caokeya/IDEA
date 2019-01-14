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
            //1. Convert the given integer to character array
            char[] ch = String.valueOf(N).toCharArray();

            //2. Create a integer mark variable and initialize it to the length of the character array
            int mark = ch.length;

            //3. Iterate from the end of the array to the beginning of the array.
            //Everytime you find current digit less then previous digit, reduce the previous digit by 1 and set that digit as the mark
            for (int i = ch.length - 1; i > 0; i--) {
                if (ch[i] < ch[i - 1]) {
                    mark = i - 1;
                    ch[i - 1]--;
                }
            }

            //4. Set all digits after mark to 9 as we want the highest number.
            //In step 3 we made sure that all digits before mark are in increasing order
            for (int i = mark + 1; i < ch.length; i++) {
                ch[i] = '9';
            }
            return Integer.parseInt(new String(ch));
        }
    }
}

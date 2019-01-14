package src.com.Java;

/*
给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
示例 1 :
输入: 2736
输出: 7236
解释: 交换数字2和数字7。
示例 2 :
输入: 9973
输出: 9973
解释: 不需要交换。
 */
public class _670_Maximum_Swap_最大交换 {
    /*
     * 使用桶记录数字0 ~ 9的最后一个位置。 从左到右循环num数组。
     * 对于每个位置，我们检查这个num中是否存在较大的数字(从9开始到当前数字)。
     * 我们还需要确保这个大数字的位置在当前数字后面。如果找到了，只需交换这两位数字并返回结果。
     */
    class Solution {
        public int maximumSwap(int num) {
            char[] digits = Integer.toString(num).toCharArray();

            int[] buckets = new int[10];
            /*
            记录0~9中各个数字所在的最后的位置
             */
            for (int i = 0; i < digits.length; i++) {
                buckets[digits[i] - '0'] = i;
            }
            /*
            从左到右循环num数组。对于每个位置，我们检查这个数字中是否存在一个较大的数字(从9开始到当前数字)。
            我们还需要确保这个大数的位置在当前数字的后面。如果我们找到它，只需交换这两个数字并返回结果。
            */
            for (int i = 0; i < digits.length; i++) {
                for (int k = 9; k > digits[i] - '0'; k--) {
                    if (buckets[k] > i) {
                        char tmp = digits[i];
                        digits[i] = digits[buckets[k]];
                        digits[buckets[k]] = tmp;
                        return Integer.valueOf(new String(digits));
                    }
                }
            }
            return num;
        }
    }
}

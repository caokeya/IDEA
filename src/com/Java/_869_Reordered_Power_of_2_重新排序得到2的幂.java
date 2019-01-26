package src.com.Java;

import java.util.Arrays;

/*
从正整数 N 开始，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
示例 1：
输入：1
输出：true
示例 2：
输入：10
输出：false
示例 3：
输入：16
输出：true
示例 4：
输入：24
输出：false
示例 5：
输入：46
输出：true
 */
public class _869_Reordered_Power_of_2_重新排序得到2的幂 {
    class Solution {
        public boolean reorderedPowerOf2(int N) {
            int[] arr = toDigitArray(N);
            for (int i = 0; i < 31; i++) {
                if (Arrays.equals(arr, toDigitArray(1 << i))) {
                    return true;
                }
            }
            return false;
        }

        private int[] toDigitArray(int N) {
            int[] array = new int[10];
            while (N > 0) {
                array[N % 10]++;
                N /= 10;
            }
            return array;
        }
    }
}

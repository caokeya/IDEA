package src.com.Java;

/*
编写一个程序，找出第 n 个丑数。
丑数就是只包含质因数 2, 3, 5 的正整数。
示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
*/
public class _264_Ugly_Number_II_只由235乘积构成的数2 {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] nums = new int[n];
            nums[0] = 1;
            int index = 0, index2 = 0, index3 = 0, index5 = 0;
            //An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
            //nums[index2] 表示已生成的ugly number数组序列中第一个未被乘以2的数字
            //nums[index3] 表示已生成的ugly number数组序列中第一个未被乘以3的数字
            //nums[index5] 表示已生成的ugly number数组序列中第一个未被乘以5的数字
            while (index + 1 < n) {
                int x2 = nums[index2] * 2;
                int x3 = nums[index3] * 3;
                int x5 = nums[index5] * 5;

                int min = Math.min(x2, Math.min(x3, x5));
                if (min == x2) ++index2;
                else if (min == x3) ++index3;
                else ++index5;

                if (min != nums[index]) {
                    nums[++index] = min;
                }
            }
            return nums[n - 1];
        }
    }
}

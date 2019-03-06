package src.com.Java;
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
示例 1:
输入: 2.00000, 10
输出: 1024.00000
 */
public class _050_Pow_x_n_X的n次幂 {
    class Solution {
        public double myPow(double x, int n) {
            int sign = 1;
            if (x < 0 && n % 2 == 1) {
                sign = -1;
            }
            x = Math.abs(x);
            return sign * Math.exp(n * Math.log(x));
        }
    }
}

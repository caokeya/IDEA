package src.com.Java;
/*
给定一个长度为 n 的整数数组 A 。
假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
计算F(0), F(1), ..., F(n-1)中的最大值。
注意:
可以认为 n 的值小于 105。
示例:
A = [4, 3, 2, 6]
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 */
public class _396_Rotate_Function_旋转函数 {
    /*
        F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
        F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
               = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
        Then,
        F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
                      = (Bk[0] + ... + Bk[n-1]) - nBk[0]
                      = sum - nBk[0]
        Thus,
        F(k) = F(k-1) + sum - nBk[0]
        What is Bk[0]?
        k = 0; B[0] = A[0];
        k = 1; B[0] = A[len-1];
        k = 2; B[0] = A[len-2];
        ...
     */
    class Solution {
        public int maxRotateFunction(int[] A) {
            int Sum = 0;
            int n = A.length;
            int F = 0;
            for (int i = 0; i < n; i++) {
                F += i * A[i];
                Sum += A[i];
            }
            int max = F;//F(0)
            for (int i = n - 1; i >= 1; i--) {
                F = F + Sum - n * A[i];
                max = Math.max(F, max);
            }
            return max;   
        }
    }
}

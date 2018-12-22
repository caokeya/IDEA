package src.com.Java;

/*
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
示例 1:
输入: 4
输出: 2
 */
public class _069_Sqrt_x_求平方根 {
    class Solution {
        public int mySqrt(int x) {
            if (x == 0)
                return 0;
            int start = 1;
            int end = x;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                    return mid;
                if (mid > x / mid)
                    end = mid;
                else
                    start = mid + 1;
            }
            return start;
        }
    }
}

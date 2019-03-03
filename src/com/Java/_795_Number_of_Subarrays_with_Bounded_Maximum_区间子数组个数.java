package com.Java;

/*
给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
例如 :
输入: 
A = [2, 1, 4, 3]
L = 2
R = 3
输出: 3
解释: 满足条件的子数组: [2], [2, 1], [3].
 */
public class _795_Number_of_Subarrays_with_Bounded_Maximum_区间子数组个数 {
    // 2 1 2 1 2 1 2 1 3 6 1 2
    // L = 2, R = 3
    // index   0  1  2  3  4  5  6  7  8  9 10 11
    //         2  1  2  1  2  1  2  1  3  6  1  2
    // count   1  1  3  3  5  5  7  7  9  0  0  2 
    // j       0                          9  9  9
    // res     1  2  5  8 13 18 25 32 41 41 41 43
    class Solution {
        public int numSubarrayBoundedMax(int[] A, int L, int R) {
            int j = 0, count = 0, res = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i] >= L && A[i] <= R) {   // A[right] is in the range
                    res += i - j + 1;
                    count = i - j + 1;//有效组合数
                } else if (A[i] < L) {  // A[right] is below L, but can be included in the range
                    res += count;
                } else {    // A[right] is above R, so we have to clean the range
                    j = i + 1;
                    count = 0;//清空有效组合数
                }
            }
            return res;
        }
    }
}

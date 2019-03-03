package com.Java;

/*
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。
示例：
输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 */
public class _922_Sort_Array_By_Parity_ll_按奇偶排序数组2 {
    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int evenPtr = 0, oddPtr = 1;
            int n = A.length;
            while (true) {
                // YW: no need to check evenPtr is even since it is always even; 
                // make sure to check evenPtr < n
                while (evenPtr < n && A[evenPtr] % 2 == 0) {
                    evenPtr += 2;
                }
                if (evenPtr >= n) {
                    break;
                }
                while (oddPtr < n && A[oddPtr] % 2 == 1) {
                    oddPtr += 2;
                }
                if (oddPtr >= n) {
                    break;
                }

                int tmp = A[evenPtr];
                A[evenPtr] = A[oddPtr];
                A[oddPtr] = tmp;
            }
            return A;
        }
    }
}

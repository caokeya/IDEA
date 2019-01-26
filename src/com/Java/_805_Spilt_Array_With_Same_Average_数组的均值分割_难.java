package src.com.Java;

import java.util.Arrays;

/*
给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
示例:
输入: 
[1,2,3,4,5,6,7,8]
输出: true
解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 */
public class _805_Spilt_Array_With_Same_Average_数组的均值分割_难 {
    /*
    思路：
    * 1) 如果B 和C 的均值 相等，那么必定 == average(A)
    * 2) sumB / lenOfB = sumA / lenOfA 也就是sumB = sumA * lenOfB / lenOfA
    * 3）因为sumB 是个integer， 因此(sumA * lenOfB) % A.length == 0
    * 4）假设B 为 B，C中数量较少的数组， 则 B的长度为[1, A.length / 2]。
         遍历 lengOfB 的长度，在A中，不断递归找到lenOfB， 来看能否找到 sumB == (sumA * lenOfB) / A.length。
     */
    class Solution {
         public boolean splitArraySameAverage(int[] A) {
            if (A.length == 1)
                return false;
            int sumA = 0;
            for (int a : A) sumA += a;
            Arrays.sort(A);
            for (int lenOfB = 1; lenOfB <= A.length / 2; lenOfB++) {
                if ((sumA * lenOfB) % A.length == 0) {
                    if (check(A, (sumA * lenOfB) / A.length, lenOfB, 0))
                        return true;
                }
            }
            return false;
        }

        public boolean check(int[] A, int leftSum, int leftNum, int startIndex) {
            if (leftNum == 0)
                return leftSum == 0;
            if ((A[startIndex]) > leftSum / leftNum)
                return false;
            for (int i = startIndex; i < A.length - leftNum + 1; i++) {
                if (i > startIndex && A[i] == A[i - 1])
                    continue;
                if (check(A, leftSum - A[i], leftNum - 1, i + 1))
                    return true;
            }
            return false;
        }
    }
}

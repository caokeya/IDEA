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
     * 3） 因为sumB 是个integer， 因此(sumA * lenOfB) % A.length == 0 
     * 4） 假设B 为 B，C中数量较少的数组， 则 B的长度为[1, A.length / 2]。 
                         遍历 lengOfB 的长度，在A中，不断递归找到lenOfB， 来看能否找到 sumB == (sumA * lenOfB) / A.length。
     */
    class Solution {
        public boolean splitArraySameAverage(int[] A) {
            if (A.length == 1)
                return false;
            int sumA = 0;
            sumA = Arrays.stream(A).sum();
            Arrays.sort(A);

            // 遍历lenOfB的长度，然后从A中，递归找出lenOfB个元素是的 sumB = (sumA * lenOfB) / A.length。
            for (int lenOfB = 1; lenOfB <= A.length / 2; lenOfB++) {
                // 如果存在sumB 为integer
                if ((sumA * lenOfB) % A.length == 0) {
                    // 递归查找A中，是否存在lenOfB个元素，使得其和为 (sumA * lenOfB) / A.length
                    if (check(A, (sumA * lenOfB) / A.length, lenOfB, 0))
                        return true;
                }
            }
            return false;
        }
        
        public boolean check(int[] A, int leftSum, int leftNum, int startIndex) {
            // 递归结束条件，如果lenthOfB ==0 ,返回 sumB是否为0.
            if (leftNum == 0)
                return leftSum == 0;
            // 如果第一个元素 已经> average, 直接return false， 因为A是排序好的。
            if ((A[startIndex]) > leftSum / leftNum)
                return false;

            // 从startIndex开始 找出 leftNum 个数字，使其和为 leftSum。 因为要找出leftNum个，因此遍历的最后一个元素为A.length-leftNum. 否则找不出足够的元素。
            for (int i = startIndex; i < A.length - leftNum + 1; i++) {
                // 如果当前的元素== 之前的元素，则直接跳过。因为 A[i-1] 在上一层的递归中已经处理过。 
                // 例子：30[A]，30[B]，30[C]，30[D]，30[E]，30[F],60
                // 当startIndex == 0,leftSum = 120 时， i =0 递归进入--> startIndex2==1, leftSum =90，
                // 遍历 （i=startIndex2<A.length - leftNum+1; i++）时，递归进入 startIndex3=2，
                // leftSum=30。假设层层遍历完成后，退出到最上层，startIndex==0层时， i取1， 继续遍历leftSum=90，此种情况已经遍历完成，故跳过。
                if (i > startIndex && A[i] == A[i - 1])
                    continue;
                if (check(A, leftSum - A[i], leftNum - 1, i + 1))
                    return true;
            }
            return false;
        }
    }
}

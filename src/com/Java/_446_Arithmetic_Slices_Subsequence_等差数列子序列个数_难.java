package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
求得一个数组中构成的等差子序列的个数
Input: [2, 4, 6, 8, 10]
Output: 7
Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
 */
public class _446_Arithmetic_Slices_Subsequence_等差数列子序列个数_难 {
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int result = 0;
            int n = A.length;
            Map<Integer, Integer>[] map = new Map[n];
            for (int i = 0; i < n; i++) {
                map[i] = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    long diff = (long) A[i] - (long) A[j];
                    if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                        continue;
                    int d = (int) diff;
                    // map[i].get(d)表示以第i个数为最后一位，差为d的，数组长度大于等于2的组合数
                    int c1 = map[i].getOrDefault(d, 0);
                    int c2 = map[j].getOrDefault(d, 0);
                    result += c2;
                    map[i].put(d, 1 + c1 + c2);
                }
            }
            return result;
        }
    }
}

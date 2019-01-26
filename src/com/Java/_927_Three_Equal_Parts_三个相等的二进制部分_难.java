package src.com.Java;

import java.util.Arrays;

/*
给定一个0和1的数组A，将数组分成3个非空的部分，使所有这些部分表示相同的二进制值。
如果有可能，返回任意[i, j]与i+1 < j，这样:
[0],[1],…， A[i]为第一部分;
(i + 1),[i + 2],…， A[j-1]为第二部分
[j],[j + 1],…(一个。长度- 1]是第三部分。
这三部分都有相等的二进制值。
如果不可能，返回[-1，-1]。
Example 1:
Input: [1,0,1,0,1]
Output: [0,3]
Example 2:
Input: [1,1,0,1,1]
Output: [-1,-1]
 */
public class _927_Three_Equal_Parts_三个相等的二进制部分_难 {
    class Solution {
        public int[] threeEqualParts(int[] A) {
            return sol1(A);
        }

        // Solution 1: O(n) Count the number of 1's and divide it by three
        // pay attention to the trailing zeros
        int[] sol1(int[] A) {
            if (A == null || A.length < 3) {
                return new int[]{-1, -1};
            }
            // count number of 1's
            int count = 0;
            for (int n : A) {
                if (n == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                // impossible
                return new int[]{-1, -1};
            }
            if (count == 0) {
                // special case, all 0's
                return new int[]{0, 2};
            }
            count /= 3; // count of 1's in each
            // count from the end backwards to find enough 1's
            int c = count;
            int k = A.length - 1;
            while (c > 0) {
                if (A[k--] == 1) {
                    c--;
                }
            }
            k++;
            // skip the leading zeros and then match from begining
            int i = 0;
            int j = k;
            while (A[i] == 0) {
                i++;
            }
            while (j < A.length) {
                if (A[i++] != A[j++]) {
                    return new int[]{-1, -1};
                }
            }
            i--; // found i
            // skip leading zeros and then match for j
            j = i + 1;
            while (A[j] == 0) {
                j++;
            }
            while (k < A.length) {
                if (A[j++] != A[k++]) {
                    return new int[]{-1, -1};
                }
            }
            return new int[]{i, j};
        }
    }
}

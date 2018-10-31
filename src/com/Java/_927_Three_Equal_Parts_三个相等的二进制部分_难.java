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
            int[] IMP = new int[] { -1, -1 };
            int ones = 0;
            for (int num : A)
                ones += num;
            if (ones % 3 != 0)
                return IMP;
            int T = ones / 3;
            int count = 0;
            int i1 = -1, i2 = -1, i3 = -1, j1 = -1, j2 = -1, j3 = -1;
            if (T == 0)
                return new int[] { 0, A.length - 1 };
            for (int i = 0; i < A.length; i++) {
                if (A[i] == 1) {
                    count++;
                    if (count == 1)
                        i1 = i;
                    if (count == T)
                        j1 = i;
                    if (count == T + 1)
                        i2 = i;
                    if (count == 2 * T)
                        j2 = i;
                    if (count == 2 * T + 1)
                        i3 = i;
                    if (count == 3 * T)
                        j3 = i;
                }
            }
            int[] array1 = Arrays.copyOfRange(A, i1, j1 + 1);
            int[] array2 = Arrays.copyOfRange(A, i2, j2 + 1);
            int[] array3 = Arrays.copyOfRange(A, i3, j3 + 1);
            if (!Arrays.equals(array1, array2))
                return IMP;
            if (!Arrays.equals(array2, array3))
                return IMP;
            int x = i2 - j1 - 1;
            int y = i3 - j2 - 1;
            int z = A.length - j3 - 1;
            if (x < z || y < z)
                return IMP;
            return new int[] { j1 + z, j2 + z + 1 };
        }
    }

    class Solution2 {
        public int[] threeEqualParts(int[] A) {
            int ones = 0;
            for (int a : A)
                ones += a;

            //
            if (ones == 0)
                return new int[] { 0, A.length - 1 };
            if (ones % 3 != 0)
                return new int[] { -1, -1 };

            //
            final int k = ones / 3;

            // first,second,third last one inds
            int[] lastOnes = new int[3];

            for (int i = 0, cnt = 0; i < A.length; i++) {
                if (A[i] == 1) {
                    cnt++;
                    if (cnt % k == 0) {
                        lastOnes[cnt / k - 1] = i;
                    }
                }
            }

            //
            int[] ends = Arrays.copyOf(lastOnes, lastOnes.length);
            while (ends[2] < A.length) {
                if (A[ends[2]] != A[ends[0]] || A[ends[2]] != A[ends[1]])
                    return new int[] { -1, -1 };
                ends[0]++;
                ends[1]++;
                ends[2]++;
            }

            int[] inds = Arrays.copyOf(lastOnes, lastOnes.length);
            while (inds[0] >= 0 && inds[1] >= ends[0] && inds[2] >= ends[1]) {
                if (A[inds[0]] != A[inds[1]] || A[inds[0]] != A[inds[2]]) {
                    return new int[] { -1, -1 };
                }
                inds[0]--;
                inds[1]--;
                inds[2]--;
            }
            while (inds[0] >= 0) {
                if (A[inds[0]] == 1)
                    return new int[] { -1, -1 };
                inds[0]--;
            }
            while (inds[1] > ends[0]) {
                if (A[inds[1]] == 1)
                    return new int[] { -1, -1 };
                inds[1]--;
            }
            while (inds[2] > ends[1]) {
                if (A[inds[2]] == 1)
                    return new int[] { -1, -1 };
                inds[2]--;
            }

            return new int[] { ends[0] - 1, ends[1] };
        }
    }
}

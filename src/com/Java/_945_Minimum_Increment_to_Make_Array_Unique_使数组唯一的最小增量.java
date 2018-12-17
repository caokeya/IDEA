package src.com.Java;

import java.util.Arrays;

/*
给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
返回使 A 中的每个值都是唯一的最少操作次数。
示例 1:
输入：[1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
示例 2:
输入：[3,2,1,2,1,7]
输出：6
解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 */
public class _945_Minimum_Increment_to_Make_Array_Unique_使数组唯一的最小增量 {
    class Solution {
        // Idea: sort the array and the next numebr should be at least prev + 1.
        // time: O(NlogN)
        public int minIncrementForUnique(int[] A) {
            // sanity check
            if (A == null || A.length == 0) {
                return 0;
            }

            // sort
            Arrays.sort(A);

            // moves of steps needed
            int moves = 0;

            int max = A[0];
            // from the second number
            for (int i = 1; i < A.length; i++) {
                if (A[i] <= max) {
                    max++;
                    moves += max - A[i];
                } else {
                    max = A[i];
                }
            }

            return moves;
        }
    }
}

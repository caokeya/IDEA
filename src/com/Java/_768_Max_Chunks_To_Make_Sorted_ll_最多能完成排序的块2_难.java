package com.Java;

/*
这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
我们最多能将数组分成多少块？
示例 1:
输入: arr = [5,4,3,2,1]
输出: 1
解释:
将数组分成2块或者更多块，都无法得到所需的结果。
例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。 
示例 2:
输入: arr = [2,1,3,4,4]
输出: 4
解释:
我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。 
 */
public class _768_Max_Chunks_To_Make_Sorted_ll_最多能完成排序的块2_难 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int[] minOfRight = new int[n];
            minOfRight[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
            }
            int res = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(max, arr[i]);
                if (max <= minOfRight[i + 1])
                    res++;// left max must be greater or equal to minofright 
            }
            return res + 1;
        }
    }

    class Solution2 {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int[] maxOfLeft = new int[n];
            int[] minOfRight = new int[n];

            maxOfLeft[0] = arr[0];
            for (int i = 1; i < n; i++) {
                maxOfLeft[i] = Math.max(maxOfLeft[i - 1], arr[i]);
            }

            minOfRight[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
            }

            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                if (maxOfLeft[i] <= minOfRight[i + 1])
                    res++;
            }

            return res + 1;
        }
    }
}

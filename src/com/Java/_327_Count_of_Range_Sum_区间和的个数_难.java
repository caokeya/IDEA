package src.com.Java;

/*
给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
示例:
输入: nums = [-2,5,-1], lower = -2, upper = 2,
输出: 3 
解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 */
public class _327_Count_of_Range_Sum_区间和的个数_难 {
    //O(nlogn)
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int n = nums.length;
            long[] sums = new long[n + 1];
            for (int i = 0; i < n; ++i)
                sums[i + 1] = sums[i] + nums[i];
            return countWhileMergeSort(sums, 0, n + 1, lower, upper);
        }

        private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
            if (end - start <= 1) return 0;
            int mid = (start + end) / 2;
            int count = countWhileMergeSort(sums, start, mid, lower, upper) +
                    countWhileMergeSort(sums, mid, end, lower, upper);
            int j = mid, k = mid, t = mid;
            long[] cache = new long[end - start];
            for (int i = start, r = 0; i < mid; ++i, ++r) {
                //k is the first index satisfy sums[k] - sums[i] >= lower.
                while (k < end && sums[k] - sums[i] < lower)
                    k++;
                //j is the first index satisfy sums[j] - sums[i] > upper.
                while (j < end && sums[j] - sums[i] <= upper)
                    j++;
                //We also use another index t to copy the elements satisfy sums[t] < sums[i] to a cache in order to complete the merge sort.
                while (t < end && sums[t] < sums[i])
                    cache[r++] = sums[t++];
                cache[r] = sums[i];
                count += j - k;
            }
            System.arraycopy(cache, 0, sums, start, t - start);//将cache从索引0开始的t-start位拷贝到sums的start位置
            return count;
        }
    }

    //O(n^2)Naive Solution
    class Solution2 {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int n = nums.length;
            long[] runSums = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                runSums[i] = runSums[i - 1] + nums[i - 1];
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    long rangeSum = runSums[j] - runSums[i - 1];
                    if (rangeSum >= lower && rangeSum <= upper) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}

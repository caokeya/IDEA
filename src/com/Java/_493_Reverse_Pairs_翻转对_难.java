package src.com.Java;

import java.util.Arrays;

/*
给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
你需要返回给定数组中的重要翻转对的数量。
示例 1:
输入: [1,3,2,3,1]
输出: 2
示例 2:
输入: [2,4,3,5,1]
输出: 3
 */
public class _493_Reverse_Pairs_翻转对_难 {
    class Solution {
        int[] copy;

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length <= 1)
                return 0;
            copy = new int[nums.length];
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int left, int right) {
            if (right - left <= 0)
                return 0;
            int mid = (right - left) / 2 + left;
            int res = 0;
            res += mergeSort(nums, left, mid);
            res += mergeSort(nums, mid + 1, right);
            for (int m = left; m <= right; m++)
                copy[m] = nums[m];
            int q = mid + 1;
            for (int p = left; p <= mid; p++) {
                while (q <= right && nums[p] / 2.0 > nums[q])
                    q++;
                res += q - mid - 1;
            }
            int i = left, j = mid + 1, k = left;
            while (k <= right) {
                if (j > right || (i <= mid && copy[i] <= copy[j])) {
                    nums[k++] = copy[i++];
                } else {
                    nums[k++] = copy[j++];
                }
            }
            return res;
        }
    }

    public class Solution2 {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int s, int e) {
            if (s >= e)
                return 0;
            int mid = s + (e - s) / 2;
            int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
            for (int i = s, j = mid + 1; i <= mid; i++) {
                while (j <= e && nums[i] / 2.0 > nums[j])
                    j++;
                cnt += j - (mid + 1);
            }
            Arrays.sort(nums, s, e + 1);
            return cnt;
        }
    }
}

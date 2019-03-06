package src.com.Java;

/*
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数
要求从同一个数组中取出的数字保持其在原数组中的相对顺序。求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
说明: 请尽可能地优化你算法的时间和空间复杂度。
示例 1:
输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
 */
public class _321_Create_Maximum_Number_拼接最大数_难 {
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            int m = nums2.length;
            int[] ans = new int[k];
            for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
                int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
                if (greater(candidate, 0, ans, 0))
                    ans = candidate;
            }
            return ans;
        }

        private int[] merge(int[] nums1, int[] nums2, int k) {
            int[] ans = new int[k];
            for (int i = 0, j = 0, r = 0; r < k; ++r)
                ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
            return ans;
        }

        public boolean greater(int[] nums1, int i, int[] nums2, int j) {
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                i++;
                j++;
            }
            return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
        }

        public int[] maxArray(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[k];
            for (int i = 0, j = 0; i < n; ++i) {
                while (n - i + j > k && j > 0 && ans[j - 1] < nums[i])
                    j--;
                if (j < k)
                    ans[j++] = nums[i];
            }
            return ans;
        }
    }
}

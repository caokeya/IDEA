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
            int len1 = nums1.length, len2 = nums2.length;
            int[] res = new int[k];
            for (int i = Math.max(0, k - len2); i <= k && i <= len1; i++) {
                int[] can = merge(maxArray(nums1, i), maxArray(nums2, k - i));
                if (larger(can, 0, res, 0)) {
                    res = can;
                }
            }
            return res;
        }

        private int[] maxArray(int[] a, int k) {
            int len = a.length;
            int valid = 0;
            int[] res = new int[k];
            for (int i = 0; i < len; i++) {
                //len - 1 is the right index of 'a', while i is the left index we have visited
                //len - 1 - i means the length we have not visited yet
                //k - 1 is the right index of 'res', while valid is next index of res we need to give value
                //k - 1 - valid is the length we need to give value on 'res'
                //if len - 1 - i > k - 1 - valid, means we still have more options left on 'a' than we need to fill 'res'
                //so we are still free to search  for a larger number to put on lower index of 'res'.
                //so this is 'greedy' actually.
                while (len - i - 1 > k - 1 - valid && valid > 0 && res[valid - 1] < a[i]) {
                    valid--;
                }
                if (valid < k) {
                    res[valid++] = a[i];
                }
            }
            return res;
        }

        private int[] merge(int[] a, int[] b) {
            int[] res = new int[a.length + b.length];
            int valid = 0, i = 0, j = 0;
            while (i < a.length && j < b.length) {
                res[valid++] = larger(a, i, b, j) ? a[i++] : b[j++];
            }
            while (i < a.length) {
                res[valid++] = a[i++];
            }
            while (j < b.length) {
                res[valid++] = b[j++];
            }
            return res;
        }

        private boolean larger(int[] a, int x, int[] b, int y) {
            while (x < a.length && y < b.length && a[x] == b[y]) {
                x++;
                y++;
            }
            return y == b.length || (x < a.length && a[x] > b[y]);
        }
    }
}

package src.com.Java;

/*
我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
    B.length >= 3
    存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
（注意：B 可以是 A 的任意子数组，包括整个数组 A。）
给出一个整数数组 A，返回最长 “山脉” 的长度。
如果不含有 “山脉” 则返回 0。
示例 1：
输入：[2,1,4,7,3,2,5]
输出：5
解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
示例 2：
输入：[2,2,2]
输出：0
解释：不含 “山脉”。
 */
public class _845_Longest_Mountain_in_Array_数组中的最长山脉 {
    /*
     * 分别从左往右、从右往左遍历数组 left记录某数字左侧的最长递增子串的长度 right记录数字右侧的最长递减子串的长度
     **/
    class Solution {
        public int longestMountain(int[] A) {
            int res = 0;
            if (A.length < 3) {
                return res;
            }
            int[] l = new int[A.length], r = new int[A.length];
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1]) {
                    l[i] = l[i - 1] + 1;
                }
            }
            for (int i = A.length - 2; i >= 0; i--) {
                if (A[i] > A[i + 1]) {
                    r[i] = r[i + 1] + 1;
                }
                if (r[i] > 0 && l[i] > 0) {
                    res = Math.max(res, l[i] + r[i] + 1);
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int longestMountain(int[] A) {
            int longestMountain = 0;
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                    int l = i - 1;
                    int r = i + 1;
                    while (l > 0 && A[l - 1] < A[l]) {
                        l--;
                    }
                    while (r < A.length - 1 && A[r + 1] < A[r]) {
                        r++;
                    }
                    longestMountain = Math.max(longestMountain, (r - l + 1));
                }
            }
            return longestMountain;
        }
    }
}

package src.com.Java;

import java.util.Arrays;

/*
给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
在此过程之后，我们得到一些数组 B。
返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
示例 1：
输入：A = [1], K = 0
输出：0
解释：B = [1]
示例 2：
输入：A = [0,10], K = 2
输出：6
解释：B = [2,8]
示例 3：
输入：A = [1,3,6], K = 3
输出：3
解释：B = [4,6,3]
 */
public class _910_Smallest_Range_ll_最小差值2 {
    class Solution {
        /*
        假设有一个点，在这个点的左边，所有元素加K，
        在点的右边，所有元素减去K，检查每一个可能的点
        max和min在这4个候选项中，A[0]+K, A[last]-K, A[point left] +K, A[point right] -K
        */
        public int smallestRangeII(int[] A, int K) {
            Arrays.sort(A);
            int ans = A[A.length - 1] - A[0];
            int left = A[0] + K;
            int right = A[A.length - 1] - K;

            for (int i = 0; i + 1 < A.length; i++) {
                int pleft = A[i] + K;
                int pright = A[i + 1] - K;

                int max = Math.max(pleft, right);
                int min = Math.min(left, pright);
                ans = Math.min(ans, max - min);
            }
            return ans;
        }
    }
}

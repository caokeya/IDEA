package com.company;

public class _042_Trapping_Rain_Water_接雨水_难 {
    class Solution {
        public int trap(int[] A) {
            int a = 0;
            int b = A.length - 1;
            int max = 0;
            int leftmax = 0;
            int rightmax = 0;
            while (a <= b) {
                leftmax = Math.max(leftmax, A[a]);
                rightmax = Math.max(rightmax, A[b]);
                if (leftmax < rightmax) {
                    max += (leftmax - A[a]); // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be
                                             // stored
                    a++;
                } else {
                    max += (rightmax - A[b]);
                    b--;
                }
            }
            return max;
        }
    }
}

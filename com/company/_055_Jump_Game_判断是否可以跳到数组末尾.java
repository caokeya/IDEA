package com.company;

public class _055_Jump_Game_判断是否可以跳到数组末尾 {
    public boolean canJump(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(A[i] + i, max);
        }
        return true;
    }
}

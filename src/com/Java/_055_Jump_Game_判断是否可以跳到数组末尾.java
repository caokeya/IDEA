package src.com.Java;
/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 */
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

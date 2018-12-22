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
public class _055_Jump_Game_跳跃游戏 {
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null) {
                return false;
            }
            int pos = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] + i >= pos) {
                    pos = i;
                }
            }
            return pos == 0;
        }
    }
}

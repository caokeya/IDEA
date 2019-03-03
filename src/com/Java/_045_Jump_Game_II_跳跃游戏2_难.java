package com.Java;
/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
示例:
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class _045_Jump_Game_II_跳跃游戏2_难 {
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int last = 0; // 上一个可以reach到的 position
            int minSteps = 0;
            int maxReach = 0;

            for (int i = 0; i < n - 1; i++) {
                maxReach = Math.max(maxReach, i + nums[i]);
                // Once the current point reaches curEnd, then trigger another jump
                if (i == last) {
                    minSteps++;
                    last = maxReach;
                    if (last == n - 1) {
                        break;
                    }
                }
            }

            return minSteps;
        }
    }
}

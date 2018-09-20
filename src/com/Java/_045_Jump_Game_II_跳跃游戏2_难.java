package src.com.Java;

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

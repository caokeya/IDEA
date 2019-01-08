package src.com.Java;

import java.util.Random;

/*
打乱一个没有重复元素的数组。
示例:
// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);
// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();
// 重设数组到它的初始状态[1,2,3]。
solution.reset();
// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 */
public class _384_Shuffle_an_Array_打乱数组 {
    class Solution {

        private int[] nums;
        private Random r;

        public Solution(int[] nums) {
            this.nums = nums;
            this.r = new Random();
        }

        /*
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return this.nums;
        }

        /*
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] arr = new int[this.nums.length];

            for (int i = 0; i < arr.length; i++) {
                int j = this.r.nextInt(i + 1);
                arr[i] = arr[j];
                arr[j] = this.nums[i];
            }
            return arr;
        }
    }
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
}

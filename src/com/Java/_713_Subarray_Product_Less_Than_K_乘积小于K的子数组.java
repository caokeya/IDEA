package src.com.Java;

/*
给定一个正整数数组 nums。
找出该数组内乘积小于 k 的连续的子数组的个数。
示例 1:
输入: nums = [10,5,2,6], k = 100
输出: 8
解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 */
public class _713_Subarray_Product_Less_Than_K_乘积小于K的子数组 {
    /*
     * Step: 
     * 1.遍历原数组，用sum乘上当前遍历到的数字， 
     * 2.然后进行while循环，如果sum大于等于k，那么这种解就是不合适的，则滑动窗口的左边界需要向右移动一位， 
     * 3.删除最左边的数字，那么少了一个数字，乘积就会改变，所以用sum除以最左边的数字，然后左边右移一位，即left自增1。 
     * 4.当我们确定了窗口的大小后，就可以统计子数组的个数了，就是窗口的大小。 
     * 5.比如[5 2 6]这个窗口，k还是100，右边界刚滑到6这个位置，这个窗口的大小就是包含6的子数组乘积小于k的个数，即[6], [2 6], [5 2 6]，正好是3个。 
     * 6.所以窗口每次向右增加一个数字，然后左边去掉需要去掉的数字后，窗口的大小就是新的子数组的个数，每次加到结果res中即可。
     */
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int res = 0;
            if (nums == null || nums.length == 0)
                return res;
            int sum = 1, left = 0;
            for (int i = 0; i < nums.length; i++) {
                sum *= nums[i];
                while (sum >= k && left <= i) {
                    sum /= nums[left];
                    left++;
                }
                res += i - left + 1;
            }
            return res;
        }
    }
}

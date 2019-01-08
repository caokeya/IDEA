package src.com.Java;

import java.util.Arrays;
import java.util.Stack;

/*
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
示例 1:
输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
public class _503_Next_Greater_Element_ll_下一个更大元素2 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ret = new int[n];
            Arrays.fill(ret, -1);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < 2 * n; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                    ret[stack.pop()] = nums[i % n];
                }
                if (i < n) {
                    stack.push(i);
                }
            }
            return ret;
        }
    }

    class Solution2 {
        public int[] nextGreaterElements(int[] nums) {
            int[] res = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            Arrays.fill(res, -1);

            // first round
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    res[stack.pop()] = nums[i];
                }
                stack.push(i);
            }

            // second round (because searching circularly)
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    res[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
            return res;
        }
    }
}

package com.Java;

/*
给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
示例:
输入:
[1,2,3]
输出:
3
解释:
只需要3次移动（注意每次移动会增加两个元素的值）：
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class _453_Minimum_Moves_to_Equal_Array_Elements_最小移动次数使数组元素相等 {
    class Solution {
        public int minMoves(int[] nums) {
            // increment n-1 elements by 1 == decrement one element by 1
            // the idea is to find the min element and count the steps
            // to make every element equals to it

            int res = 0;
            int min = Integer.MAX_VALUE;
            for (int n : nums) {
                if (min > n)
                    min = n;
            }
            for (int n : nums) {
                res += n - min;
            }
            return res;
        }
    }
}

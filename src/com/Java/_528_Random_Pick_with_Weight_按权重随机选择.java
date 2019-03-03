package com.Java;

import java.util.Arrays;
import java.util.Random;

/*
给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 成正比。
说明:
    1 <= w.length <= 10000
    1 <= w[i] <= 10^5
    pickIndex 将被调用不超过 10000 次
示例1:
输入: 
["Solution","pickIndex"]
[[[1]],[]]
输出: [null,0]
示例2:
输入: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
输出: [null,0,1,1,1,0]
 */
public class _528_Random_Pick_with_Weight_按权重随机选择 {

    class Solution {
        Random rdm = new Random();
        int[] cur;

        public Solution(int[] w) {
            if (w == null || w.length == 0)
                return;
            cur = new int[w.length];
            cur[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                cur[i] = w[i] + cur[i - 1];
            }
        }

        public int pickIndex() {
            int left = 0, right = cur.length - 1;
            int target = rdm.nextInt(cur[cur.length - 1]) + 1;

            while (left + 1 < right) {
                int mid = (right - left) / 2 + left;
                int midval = cur[mid];

                if (midval > target) {
                    right = mid;
                } else if (midval < target) {
                    left = mid;
                } else {
                    return mid;
                }
            }
            if (cur[left] >= target) {
                return left;
            }
            if (cur[right] >= target) {
                return right;
            }

            return -1;
        }
    }

    class Solution2 {
        int total;
        int[] sum;

        public Solution2(int[] w) {
            sum = new int[w.length];
            total = 0;
            for (int i = 0; i < w.length; i++) {
                total += w[i];
                sum[i] = total;
            }
        }

        public int pickIndex() {
            int random = (int) (Math.random() * total + 1);
            int index = Arrays.binarySearch(sum, random);
            if (index < 0)
                index = -index - 1;
            return index;

        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */


}

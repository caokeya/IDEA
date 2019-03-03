package com.Java;

/*
珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
示例 1：
输入: piles = [3,6,7,11], H = 8
输出: 4
示例 2：
输入: piles = [30,11,23,4,20], H = 5
输出: 30
示例 3：
输入: piles = [30,11,23,4,20], H = 6
输出: 23
 */
public class _875_KoKo_Eating_Bananas_爱吃香蕉的珂珂 {
    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int max = piles[0];

            for (int n : piles)
                max = Math.max(max, n);

            int l = 1, r = max;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                int h = 0;
                for (int n : piles) {
                    h += (n - 1) / mid + 1;
                }
                if (h <= H) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    class Solution2 {
        public int minEatingSpeed(int[] piles, int H) {
            int i = 0;
            int j = Integer.MAX_VALUE - 1;

            int res = Integer.MAX_VALUE;
            int speed = 0;

            while (i < j - 1) {
                speed = (i + j) / 2;
                int time = 0;
                for (int pile : piles)
                    time += ((pile - 1) / speed + 1);

                if (time <= H) {
                    j = speed;
                    res = Math.min(speed, res);
                }

                else {
                    i = speed;
                }

            }

            return j;
        }
    }
}

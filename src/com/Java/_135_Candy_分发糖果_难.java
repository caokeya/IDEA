package src.com.Java;

import java.util.Arrays;

/*
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：
    每个孩子至少分配到 1 个糖果。
    相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？
示例 1:
输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 */
public class _135_Candy_分发糖果_难 {
    class Solution {
        public int candy(int[] ratings) {
            int candies[] = new int[ratings.length];
            Arrays.fill(candies, 1);// Give each child 1 candy
            for (int i = 1; i < candies.length; i++) {// Scan from left to right, to make sure right higher rated child
                                                      // gets 1 more candy than left lower rated child
                if (ratings[i] > ratings[i - 1])
                    candies[i] = (candies[i - 1] + 1);
            }
            for (int i = candies.length - 2; i >= 0; i--) {// Scan from right to left, to make sure left higher rated
                                                           // child gets 1 more candy than right lower rated child
                if (ratings[i] > ratings[i + 1])
                    candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
            }
            int sum = 0;
            for (int candy : candies)
                sum += candy;
            return sum;
        }
    }
}

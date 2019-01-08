package src.com.Java;

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

        Random random;
        int[] wSums;

        public Solution(int[] w) {
            this.random = new Random();
            for (int i = 1; i < w.length; ++i)
                w[i] += w[i - 1];
            this.wSums = w;
        }

        public int pickIndex() {
            int len = wSums.length;
            int idx = random.nextInt(wSums[len - 1]) + 1;
            int left = 0, right = len - 1;
            // search position
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (wSums[mid] <= idx)
                    left = mid;
                else right = mid;
            }

            if (wSums[left] >= idx) return left;
            else return right;
        }
    }
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
}

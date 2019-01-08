package src.com.Java;

/*
假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。
如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
示例 1：
输入: [1,0,5]
输出: 3
解释: 
第一步:    1     0 <-- 5    =>    1     1     4
第二步:    1 <-- 1 <-- 4    =>    2     1     3    
第三步:    2     1 <-- 3    =>    2     2     2   
示例 2：
输入: [0,3,0]
输出: 2
解释: 
第一步:    0 <-- 3     0    =>    1     2     0    
第二步:    1     2 --> 0    =>    1     1     1     
 */
public class _517_Super_Washing_Machines_超级洗衣机_难 {
    class Solution {
        public int findMinMoves(int[] machines) {
            if (machines == null || machines.length == 0) return -1;
            int sum = 0, n = machines.length;
            for (int i = 0; i < n; i++) {
                sum += machines[i];
            }
            if (sum % n != 0) return -1;
            int target = sum / n;
            int res = 0, cur = 0;
            for (int num : machines) {
                int diff = num - target;
                res = Math.max(res, diff);
                cur += diff;
                res = Math.max(res, Math.abs(cur));
            }
            return res;
        }
    }
}

package src.com.Java;

/*
给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
② 如果存在多种答案，你只需实现并返回其中任意一种.
示例 1:
输入: n = 3, k = 1
输出: [1, 2, 3]
解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1 个不同整数 : 1
示例 2:
输入: n = 3, k = 2
输出: [1, 3, 2]
解释: [1, 3, 2] 包含 3 个范围在 1-3 的不同整数， 并且 [2, 1] 中有且仅有 2 个不同整数: 1 和 2
 */
public class _667_Beautiful_Arrangement_II_优美的排列2 {
    /*
    small: 1   2   3   4   5
    large:   9   8   7   6
    out:   1 9 2 8 3 7 4 6 5
    dif:    8 7 6 5 4 3 2 1
     */
    class Solution {
        public int[] constructArray(int n, int k) {
            if (k >= n) return null;
            int[] arr = new int[n];
            int i = 0, small = 1, large = n;
            while (i < k) {
                arr[i++] = small++;
                if (i < k)
                    arr[i++] = large--;
            }
            if (k % 2 == 0) { // k==2 ==> 1, 6, 5,4,3,2
                while (i < arr.length)
                    arr[i++] = large--;
            } else { // k==3 ==> 1,6,2,3,4,5
                while (i < arr.length)
                    arr[i++] = small++;
            }
            return arr;
        }
    }
}

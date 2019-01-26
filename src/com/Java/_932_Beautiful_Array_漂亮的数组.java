package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
那么数组 A 是漂亮数组。
给定 N，返回任意漂亮数组 A（保证存在一个）。
示例 1：
输入：4
输出：[2,1,4,3]
示例 2：
输入：5
输出：[3,1,2,5,4]
 */
public class _932_Beautiful_Array_漂亮的数组 {
    class Solution {
        public int[] beautifulArray(int N) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            while (list.size() < N) {
                List<Integer> tmp = new ArrayList<>();
                // 添加 1 to N * 2 -1 的所有奇数
                // A = [2, 1, 4, 5, 3]
                // A1 = [3, 1, 7, 9, 5]
                for (int i : list) {
                    if (i * 2 - 1 <= N) {
                        tmp.add(i * 2 - 1);
                    }
                }
                // 添加 1 to N * 2 的所有偶数
                // A = [2, 1, 4, 5, 3]
                // A2 = [4, 2, 8, 10, 6]
                for (int i : list) {
                    if (i * 2 <= N) {
                        tmp.add(i * 2);
                    }
                }
                // 继续下一轮数组的倍增
                list = tmp;
            }
            // 添加到答案
            int[] res = new int[N];
            for (int i = 0; i < N; ++i) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
}

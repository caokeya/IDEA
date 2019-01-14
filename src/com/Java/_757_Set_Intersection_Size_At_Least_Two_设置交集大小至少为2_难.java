package src.com.Java;

import java.util.Arrays;
import java.util.Comparator;

/*
一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
输出这个最小集合S的大小。
示例 1:
输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
输出: 3
解释:
考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
且这是S最小的情况，故我们输出3。
示例 2:
输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
输出: 5
解释:
最小的集合S = {1, 2, 3, 4, 5}.
 */
public class _757_Set_Intersection_Size_At_Least_Two_设置交集大小至少为2_难 {
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // if return value > 0, o1 will behind o2
                    if (o1[1] != o2[1])
                        return (o1[1] - o2[1]);
                    else
                        return o2[0] - o1[0];
                }
            });
            int[] maxtwo = new int[]{-1, -1};
            int res = 0;
            for (int[] t : intervals) {
                if (maxtwo[0] >= t[0])
                    continue; // already have two in this interval
                else if (maxtwo[1] >= t[0]) { // take the largest one in the interval
                    res += 1;
                    maxtwo[0] = maxtwo[1];
                    maxtwo[1] = t[1];
                } else { // neither is in current interval, add largest two
                    res += 2;
                    maxtwo[1] = t[1];
                    maxtwo[0] = t[1] - 1;
                }
            }
            return res < 2 ? 2 : res;
        }
    }

    class Solution2 {
        public int intersectionSizeTwo(int[][] intervals) {
            // Meeting Room -> Greedy Approach
            // 按end排序
            // 注意set S里的数不需要连续 - 所以不能用binary search
            Arrays.sort(intervals, (interval1, interval2) -> (interval1[1] - interval2[1])); // 按end排序
            int max1 = -1, max2 = -1, ans = 0; // 当前解set S中的最大两个值
            for (int[] interval : intervals) {
                int start = interval[0], end = interval[1]; // 当前interval
                if (start > max1) { // 没有overlap
                    ans += 2; // 添加当前interval的末尾两个数-greedy
                    max2 = end - 1; // 注意set S里的数不需要连续
                    max1 = end;
                } else if (start > max2) { // overlap一个数
                    ans++; // 只添加interval的末尾一个数
                    max2 = (max1 == end ? max1 - 1 : max1); // 处理corner case
                    max1 = end;
                }
            }
            return ans;
        }
    }
}

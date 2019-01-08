package src.com.Java;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
示例:
输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出: 3 
解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class _354_Russian_Doll_Envelopes_俄罗斯套娃信封_难 {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2)
                return 0;
            // 经过sort之后implicitly降维，width就不必考虑了
            Arrays.sort(envelopes, new Comparator<int[]>() {
                public int compare(int[] arr1, int[] arr2) {
                    if (arr1[0] == arr2[0])
                        return arr2[1] - arr1[1];
                    else
                        return arr1[0] - arr2[0];
                }
            });
            int[] dp = new int[envelopes.length];
            int len = 0;
            for (int[] envelope : envelopes) {
                // 只考虑高度
                int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
                if (index < 0)
                    index = -(index + 1);
                dp[index] = envelope[1];
                if (index == len)
                    len++;
            }
            return len;
        }
    }
}

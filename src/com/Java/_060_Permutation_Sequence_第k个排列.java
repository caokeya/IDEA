package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
给定 n 和 k，返回第 k 个排列。
说明：
    给定 n 的范围是 [1, 9]。
    给定 k 的范围是[1,  n!]。
示例 1:
输入: n = 3, k = 3
输出: "213"
 */
public class _060_Permutation_Sequence_第k个排列 {
    /*
     * 如果将所有的组合均找出来，然后选第k个，这样复杂度会比较高，因此可以换一种思路。 直接从前到后算每个位置应该填补的数即可。
     */
    // 先初始化n位数存在的全排列种类。此处为了方便理解，从0开始到n位，然后数组下标就表示n位的情况。
    class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> nums = new ArrayList<>();

            int factor = 1;
            for (int i = 1; i <= n; i++) {
                nums.add(i);
                factor = factor * i;
            }

            k--;// 因为计数是从0开始的
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                factor = factor / (n - i);
                int index = k / factor;
                sb.append(nums.get(index));
                nums.remove(index);
                k = k % factor;
            }

            return sb.toString();
        }
    }
}

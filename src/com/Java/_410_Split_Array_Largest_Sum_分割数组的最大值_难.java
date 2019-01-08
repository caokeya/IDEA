package src.com.Java;

/*
给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
注意:
数组长度 n 满足以下条件:
    1 ≤ n ≤ 1000
    1 ≤ m ≤ min(50, n)
示例:
输入:
nums = [7,2,5,10,8]
m = 2
输出:
18
解释:
一共有四种方法将nums分割为2个子数组。
其中最好的方式是将其分为[7,2,5] 和 [10,8]，
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
public class _410_Split_Array_Largest_Sum_分割数组的最大值_难 {
    class SolutionDP {
        public int splitArray(int[] nums, int m) {
            int len = nums.length;
            int[] S = new int[len + 1];
            S[0] = 0;
            for (int i = 0; i < len; i++)
                S[i + 1] = S[i] + nums[i];

            int[] dp = new int[len];
            for (int i = 0; i < len; i++)
                dp[i] = S[len] - S[i];

            for (int s = 1; s < m; s++) {
                for (int i = 0; i < len - s; i++) {
                    dp[i] = Integer.MAX_VALUE;
                    for (int j = i + 1; j <= len - s; j++) {
                        int t = Math.max(dp[j], S[j] - S[i]);
                        if (t <= dp[i])
                            dp[i] = t;
                        else
                            break;
                    }
                }
            }
            return dp[0];
        }
    }

    class Solution {
        public int splitArray(int[] nums, int m) {
            int max = 0;
            long sum = 0;
            for (int num : nums) {
                max = Math.max(num, max);
                sum += num;
            }

            //binary search for max_sum of each group
            long l = max, r = sum;
            while (l < r) {
                long mid = l + (r - l) / 2;
                int cnt = groupCnt(nums, mid);
                if (cnt > m) l = mid + 1;  // cnt == m does not mean to stop
                else r = mid;
            }
            return (int) r;
        }

        private int groupCnt(int[] nums, long target) {
            int groupCnt = 1, sum = 0;
            for (int num : nums) {
                if (sum + num <= target) sum += num;
                else {
                    groupCnt++;
                    sum = num;
                }
            }
            return groupCnt;
        }
    }
}

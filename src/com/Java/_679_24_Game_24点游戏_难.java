package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
示例 1:
输入: [4, 1, 8, 7]
输出: True
解释: (8-4) * (7-1) = 24
示例 2:
输入: [1, 2, 1, 2]
输出: False
 */
public class _679_24_Game_24点游戏_难 {
    class Solution {
        public boolean judgePoint24(int[] nums) {
            double[] a = new double[nums.length];
            for (int i = 0; i < nums.length; i++)
                a[i] = (double) nums[i];
            return find(a);
        }

        private boolean find(double[] nums) {
            if (nums.length == 1) return Math.abs(nums[0] - 24) < 1e-6;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // pick every two numbers for a result
                    double[] results = calc(nums[i], nums[j]);
                    double[] next = new double[n - 1];
                    int idx = 0;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            next[idx++] = nums[k];
                        }
                    }
                    for (double r : results) {
                        next[idx] = r;
                        if (find(next)) return true;
                    }
                }
            }
            return false;
        }

        private double[] calc(double a, double b) {
            return new double[]{a + b, a - b, b - a, a * b, a / b, b / a};
        }
    }

    class Solution2 {

        public boolean judgePoint24(int[] nums) {
            List<Double> list = new ArrayList<>();
            for (int i : nums) {
                list.add((double) i);
            }
            return dfs(list);
        }

        private boolean dfs(List<Double> list) {
            if (list.size() == 1) {
                if (Math.abs(list.get(0) - 24.0) < 0.000001) {
                    return true;
                }
                return false;
            }

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (double c : generatePossibleResults(list.get(i), list.get(j))) {
                        List<Double> nextRound = new ArrayList<>();
                        nextRound.add(c);
                        for (int k = 0; k < list.size(); k++) {
                            if (k == j || k == i)
                                continue;
                            nextRound.add(list.get(k));
                        }
                        if (dfs(nextRound)) return true;
                    }
                }
            }
            return false;

        }

        private List<Double> generatePossibleResults(double a, double b) {
            List<Double> res = new ArrayList<>();
            res.add(a + b);
            res.add(a - b);
            res.add(b - a);
            res.add(a * b);
            res.add(a / b);
            res.add(b / a);
            return res;
        }
    }
}

package src.com.Java;

import java.util.Arrays;
import java.util.Comparator;

/*
有一些工作：difficulty[i] 表示第i个工作的难度，profit[i]表示第i个工作的收益。
现在我们有一些工人。worker[i]是第i个工人的能力，即该工人只能完成难度小于等于worker[i]的工作。
每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
举个例子，如果3个工人都尝试完成一份报酬为1的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
我们能得到的最大收益是多少？
示例：
输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
输出: 100 
解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 */
public class _826_Most_Profit_Assigning_Work_安排工作以达到最大收益 {
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int[][] diffProfit = new int[difficulty.length][2];
            for (int i = 0; i < difficulty.length; i++) {
                diffProfit[i][0] = difficulty[i];
                diffProfit[i][1] = profit[i];
            }
            Arrays.sort(diffProfit, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
            Arrays.sort(worker);
            int totalSum = 0;
            int currentJob = 0;
            int best = 0;
            for (int i = 0; i < worker.length; i++) {
                while (currentJob < diffProfit.length && worker[i] >= diffProfit[currentJob][0]) {
                    best = Math.max(best, diffProfit[currentJob][1]);
                    currentJob++;
                }
                totalSum += best;
            }
            return totalSum;
        }
    }
}

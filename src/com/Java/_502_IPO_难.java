package src.com.Java;

import java.util.PriorityQueue;

/*
假设 LeetCode 即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，LeetCode希望在 IPO 之前开展一些项目以增加其资本。 
由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 LeetCode 设计完成最多 k 个不同项目后得到最大总资本的方式。
给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。
最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
示例 1:
输入: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
输出: 4
解释:
由于你的初始资本为 0，你尽可以从 0 号项目开始。
在完成后，你将获得 1 的利润，你的总资本将变为 1。
此时你可以选择开始 1 号或 2 号项目。
由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 */
public class _502_IPO_难 {
    /*
    创建(资本、利润)对，并将它们放入PriorityQueue pqCap中。这种优先次序越来越按资本排序。
    将轮询对从pqCap，直到项目超出当前的资本能力。把它们放进优先队列pqPro，按利润递减排序。
    来自pqPro的调查显示，它保证是一个利润最大化的项目，并且在目前的资本能力范围内。把利润加到资本W中。
    重复步骤2和3，直到完成k个步骤或没有合适的项目(pqPro.isEmpty())。
     */
    public class Solution {
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
            for (int i = 0; i < Profits.length; i++) {
                pqCap.add(new int[]{Capital[i], Profits[i]});
            }
            for (int i = 0; i < k; i++) {
                while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                    pqPro.add(pqCap.poll());
                }

                if (pqPro.isEmpty())
                    break;
                W += pqPro.poll()[1];
            }
            return W;
        }
    }
}

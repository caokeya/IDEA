package src.com.Java;

import java.util.Arrays;

/*
两个玩家分别扮演猫（Cat）和老鼠（Mouse）在无向图上进行游戏，他们轮流行动。
该图按下述规则给出：graph[a] 是所有结点 b 的列表，使得 ab 是图的一条边。
老鼠从结点 1 开始并率先出发，猫从结点 2 开始且随后出发，在结点 0 处有一个洞。
在每个玩家的回合中，他们必须沿着与他们所在位置相吻合的图的一条边移动。例如，如果老鼠位于结点 1，那么它只能移动到 graph[1] 中的（任何）结点去。
此外，猫无法移动到洞（结点 0）里。
然后，游戏在出现以下三种情形之一时结束：
    如果猫和老鼠占据相同的结点，猫获胜。
    如果老鼠躲入洞里，老鼠获胜。
    如果某一位置重复出现（即，玩家们的位置和移动顺序都与上一个回合相同），游戏平局。
给定 graph，并假设两个玩家都以最佳状态参与游戏，如果老鼠获胜，则返回 1；如果猫获胜，则返回 2；如果平局，则返回 0。
示例：
输入：[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
输出：0
解释：
4---3---1
|   |
2---5
 \ /
  0
 */
public class _913_Cat_and_Mouse_猫和老鼠_难 {
    class Solution {
        public int catMouseGame(int[][] graph) {
            int size = graph.length;
            int dp[][] = new int[size][size];
            for (int i = 0; i < size; i++)
                Arrays.fill(dp[i], -1);

            for (int i = 0; i < size; ++i) {
                dp[0][i] = 1; // mouse reached home, m win
                dp[i][i] = 2; // cat met mouse, cat win
            }

            return helper(graph, 1, 2, dp);
        }

        public int helper(int[][] graph, int mouse, int cat, int dp[][]) {

            if (dp[mouse][cat] != -1)
                return dp[mouse][cat]; // use cached value

            dp[mouse][cat] = 0; // if there is a cycle, draw
            int mouseDefault = 2; // default cat win, try to update this number to 1 or 0
            int[] mouseGoList = graph[mouse], catGoList = graph[cat];

            for (int mouseGo : mouseGoList) {
                if (mouseGo == cat)
                    continue; // I'm a mouse, why go for a cat?

                int catDefault = 1; // default mouse win, try to update this number to 2 or 0
                for (int catGo : catGoList) {
                    if (catGo == 0)
                        continue; // cannot go to hole
                    int next = helper(graph, mouseGo, catGo, dp);
                    if (next == 2) { // if cat win in this path, no need to continue
                        catDefault = 2;
                        break;
                    }
                    if (next == 0) { // at least it's a draw
                        catDefault = 0;
                    }
                }
                if (catDefault == 1) { // if mouse can win in this path, no need to continue
                    mouseDefault = 1;
                    break;
                }
                if (catDefault == 0) { // at least it's a draw
                    mouseDefault = 0;
                }
            }
            dp[mouse][cat] = mouseDefault;
            return dp[mouse][cat];
        }
    }
}

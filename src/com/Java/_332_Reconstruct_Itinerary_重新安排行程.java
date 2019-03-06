package src.com.Java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
说明:
    如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
    所有的机场都用三个大写字母表示（机场代码）。
    假定所有机票至少存在一种合理的行程。
示例 1:
输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 */
public class _332_Reconstruct_Itinerary_重新安排行程 {
    public class Solution {

        Map<String, PriorityQueue<String>> flights;
        LinkedList<String> path;

        public List<String> findItinerary(String[][] tickets) {
            flights = new HashMap<>();
            path = new LinkedList<>();
            for (String[] ticket : tickets) {
                flights.putIfAbsent(ticket[0], new PriorityQueue<>());
                flights.get(ticket[0]).add(ticket[1]);
            }
            dfs("JFK");
            return path;
        }

        public void dfs(String departure) {
            PriorityQueue<String> arrivals = flights.get(departure);
            while (arrivals != null && !arrivals.isEmpty())
                dfs(arrivals.poll());
            path.addFirst(departure);
        }
    }
}

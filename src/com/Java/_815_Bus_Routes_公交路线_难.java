package com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。
例如，有一条路线 routes[0] = [1, 5, 7]，表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。
假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。
示例:
输入: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
输出: 2
解释: 
最优策略是先乘坐第一辆公交车到达车站 7, 然后换乘第二辆公交车到车站 6。
 */
public class _815_Bus_Routes_公交路线_难 {
    class Solution {
        public int numBusesToDestination(int[][] routes, int S, int T) {
            if (routes == null || routes.length == 0)
                return 0;
            if (S == T)
                return 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < routes.length; i++) {
                for (int j = 0; j < routes[i].length; j++) {
                    List<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                    buses.add(i);
                    map.put(routes[i][j], buses);
                }
            }

            // Station
            Queue<Integer> queue = new LinkedList<>();
            // Buses
            Set<Integer> visited = new HashSet<>();
            int count = 0;
            queue.offer(S);
            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;
                for (int i = 0; i < size; i++) {
                    int nextStation = queue.poll();
                    List<Integer> buses = map.get(nextStation);
                    for (int bus : buses) {
                        if (visited.contains(bus))
                            continue;
                        visited.add(bus);
                        for (int station : routes[bus]) {
                            if (station == T)
                                return count;
                            queue.offer(station);
                        }
                    }
                }
            }
            return -1;
        }
    }
}

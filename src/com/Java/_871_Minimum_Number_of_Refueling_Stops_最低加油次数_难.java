package com.Java;

import java.util.Collections;
import java.util.PriorityQueue;

/*
汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
示例 1：
输入：target = 1, startFuel = 1, stations = []
输出：0
解释：我们可以在不加油的情况下到达目的地。
示例 2：
输入：target = 100, startFuel = 1, stations = [[10,100]]
输出：-1
解释：我们无法抵达目的地，甚至无法到达第一个加油站。
示例 3：
输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
输出：2
解释：
我们出发时有 10 升燃料。
我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
我们沿途在两个加油站停靠，所以返回 2 。
 */
public class _871_Minimum_Number_of_Refueling_Stops_最低加油次数_难 {
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
            int res = 0, cur = startFuel, i = 0;
            while (true) {
                if (cur >= target) {
                    return res;
                }
                while (i < stations.length && stations[i][0] <= cur) {
                    maxheap.offer(stations[i++][1]);
                }
                if (maxheap.isEmpty()) {
                    break;
                }
                cur += maxheap.poll();
                res++;
            }
            return -1;
        }
    }
}

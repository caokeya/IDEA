package src.com.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
有 N 个网络节点，标记为 1 到 N。
给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，
其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 */
public class _743_Network_Delay_Time_网络延迟时间 {
    class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[K - 1] = 0;
            for (int i = 0; i < N; ++i) {
                for (int[] time : times) {
                    int from = time[0] - 1, to = time[1] - 1, t = time[2];
                    if (dist[from] != Integer.MAX_VALUE && dist[to] > dist[from] + t) {
                        dist[to] = dist[from] + t;
                    }
                }
            }
            int res = 0;
            for (int d : dist) {
                if (d == Integer.MAX_VALUE) {
                    return -1;
                }
                res = Math.max(res, d);
            }
            return res;
        }
    }

    class Solution2 {
        public int networkDelayTime(int[][] times, int N, int K) {
            int[][] g = new int[N + 1][N + 1];
            int[] cost = new int[N + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            for (int i = 0; i <= N; i++)
                Arrays.fill(g[i], -1);
            for (int[] t : times) {
                g[t[0]][t[1]] = t[2];
            }

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] { K, 0 });
            cost[K] = 0;
            Set<Integer> visited = new HashSet<>();
            visited.add(K);
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 1; i <= N; i++) {
                    if (g[cur[0]][i] != -1 && cur[1] + g[cur[0]][i] < cost[i]) {
                        cost[i] = cur[1] + g[cur[0]][i];
                        q.add(new int[] { i, cost[i] });
                        visited.add(i);
                    }
                }
            }
            int res = 0;
            for (int i = 1; i <= N; i++) {
                res = Math.max(res, cost[i]);
            }
            return visited.size() < N ? -1 : res;
        }
    }

}

package src.com.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。
对它进行优化使其尽量少调用系统方法 Math.random() 。
提示:
    1 <= N <= 1000000000
    0 <= B.length < min(100000, N)
    [0, N) 不包含 N，详细参见 interval notation 。
示例 1:
输入: 
["Solution","pick","pick","pick"]
[[1,[]],[],[],[]]
输出: [null,0,0,0]
示例 2:
输入: 
["Solution","pick","pick","pick"]
[[2,[]],[],[],[]]
输出: [null,1,1,1]
示例 3:
输入: 
["Solution","pick","pick","pick"]
[[3,[1]],[],[],[]]
Output: [null,0,0,2]
示例 4:
输入: 
["Solution","pick","pick","pick"]
[[4,[2]],[],[],[]]
输出: [null,1,3,1]
 */
public class _710_Random_Pick_with_Blacklist_黑名单中的随机数_难 {
    class Solution {

        private int n, N;
        private Map<Integer, Integer> map = new HashMap<>();

        public Solution(int N, int[] blacklist) {
            this.N = N;
            this.n = N - blacklist.length;
            for (int b : blacklist) {
                map.put(b, -1);
            }
            int low = n;
            int high = N;
            for (int b : blacklist) {
                if (b < n) {
                    for (int i = low; i < high; i++) {
                        if (!map.containsKey(i)) {
                            map.put(b, i);
                            low = i + 1;
                            break;
                        }
                    }
                }
            }
        }

        public int pick() {
            int num = ((int) Math.floor(Math.random() * n));
            if (map.containsKey(num)) {
                return map.get(num);
            }
            return num;
        }
    }
    
    class Solution2 {
        int M;
        Map<Integer, Integer> map;
        Random r;

        public Solution2(int N, int[] blacklist) {
            M = N - blacklist.length;
            map = new HashMap<>();
            r = new Random();
            for (int tmp : blacklist) {
                map.put(tmp, -1);
            }

            for (int tmp : blacklist) {
                if (tmp < M) {
                    while (map.containsKey(N - 1)) {
                        N--;
                    }
                    map.put(tmp, --N);
                }
            }
        }

        public int pick() {
            // random in [0,N) not in blacklist
            int p = r.nextInt(M);
            if (map.containsKey(p))
                return map.get(p);
            return p;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(N, blacklist);
     * int param_1 = obj.pick();
     */
}

package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
对于某个固定的N，如果数组A是整数1,2，…， N，这样:
对于每个i < j, i < k < j，没有k，使得A[k] * 2 = A[i] + A[j]。
给定N，返回任何漂亮的数组a(保证有一个存在)。
 */
public class _932_Beautiful_Array_漂亮的数组 {
    class Solution {
        Map<Integer, int[]> memo;

        public int[] beautifulArray(int N) {
            memo = new HashMap<Integer, int[]>();
            return f(N);
        }

        public int[] f(int N) {
            if (memo.containsKey(N))
                return memo.get(N);

            int[] ans = new int[N];
            if (N == 1) {
                ans[0] = 1;
            } else {
                int t = 0;
                for (int x : f((N + 1) / 2)) // odds
                    ans[t++] = 2 * x - 1;
                for (int x : f(N / 2)) // evens
                    ans[t++] = 2 * x;
            }
            memo.put(N, ans);
            return ans;
        }
    }
}

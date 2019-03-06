package src.com.Java;

import java.util.Arrays;

/*
冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
说明:
    给出的房屋和供暖器的数目是非负数且不会超过 25000。
    给出的房屋和供暖器的位置均是非负数且不会超过10^9。
    只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
    所有供暖器都遵循你的半径标准，加热的半径也一样。
示例 1:
输入: [1,2,3],[2]
输出: 1
解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 */
public class _475_Heaters_供暖器 {

    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            int max = 0;
            int i = 0;
            Arrays.sort(heaters);
            Arrays.sort(houses);
            for (int house : houses) {
                while (i < heaters.length - 1 && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                    ++i;
                }
                max = Math.max(max, Math.abs(heaters[i] - house));
            }
            return max;
        }
    }

    class Solution2 {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int[] distances = new int[houses.length];
            Arrays.fill(distances, Integer.MAX_VALUE);
            // left scan
            int j = 0;
            for (int i = 0; i < houses.length; i++) {
                while (j + 1 < heaters.length && heaters[j + 1] <= houses[i])
                    j++;
                if (heaters[j] <= houses[i])
                    distances[i] = houses[i] - heaters[j];
            }
            // right scan
            j = heaters.length - 1;
            for (int i = houses.length - 1; i >= 0; i--) {
                while (j - 1 >= 0 && heaters[j - 1] >= houses[i])
                    j--;
                if (heaters[j] >= houses[i])
                    distances[i] = Math.min(distances[i], heaters[j] - houses[i]);
            }
            int ans = Integer.MIN_VALUE;
            for (int dist : distances)
                ans = Math.max(dist, ans);

            return ans;
        }
    }

}

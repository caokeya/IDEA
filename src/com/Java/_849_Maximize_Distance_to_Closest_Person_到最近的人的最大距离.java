package src.com.Java;

/*
在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
至少有一个空座位，且至少有一人坐在座位上。
亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
返回他到离他最近的人的最大距离。
示例 1：
输入：[1,0,0,0,1,0,1]
输出：2
解释：
如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
因此，他到离他最近的人的最大距离是 2 。 
示例 2：
输入：[1,0,0,0]
输出：3
解释： 
如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
这是可能的最大距离，所以答案是 3 。
 */
public class _849_Maximize_Distance_to_Closest_Person_到最近的人的最大距离 {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int prev = -1;
            int max = -1;
            int fixFirst = -1;
            int fixLast = 0;
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 1) {
                    if (fixFirst == -1) {
                        fixFirst = i;//记录第一个1，01000
                    }
                    fixLast = Math.max(i, fixLast);//记录最后一个1，00010
                    if (prev != -1) {
                        max = Math.max(i - prev, max);
                    }
                    prev = i;//记录前一个1的位置
                }
            }
            return Math.max(Math.max(fixFirst, seats.length - 1 - fixLast), max / 2);//第一个1，最后一个1，0个数的一半
        }
    }

    class Solution2 {
        public int maxDistToClosest(int[] seats) {
            int maxDist = 0;
            int n = seats.length;
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 0) {
                    int start = i;
                    while (i < n && seats[i] == 0)
                        i++;
                    if (start == 0 || i == n) {
                        maxDist = Math.max(maxDist, i - start);
                    } else {
                        if ((i - start) % 2 == 0) {
                            maxDist = Math.max(maxDist, (i - start) / 2);
                        } else {
                            maxDist = Math.max(maxDist, (i - start) / 2 + 1);
                        }
                    }
                }
            }
            return maxDist;
        }
    }
}

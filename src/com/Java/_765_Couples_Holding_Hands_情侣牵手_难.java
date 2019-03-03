package com.Java;

/*
N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
示例 1:
输入: row = [0, 2, 1, 3]
输出: 1
解释: 我们只需要交换row[1]和row[2]的位置即可。
示例 2:
输入: row = [3, 2, 0, 1]
输出: 0
解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 */
public class _765_Couples_Holding_Hands_情侣牵手_难 {
    class Solution {
        public int minSwapsCouples(int[] row) {
            if (row == null || row.length == 0) {
                return -1;
            }

            int res = 0;

            for (int i = 0; i < row.length - 1; i += 2) {
                if (row[i + 1] == (row[i] ^ 1)) {
                    continue;
                }

                res++;

                for (int j = i + 1; j < row.length; j++) {
                    if (row[j] == (row[i] ^ 1)) {
                        int t = row[j];
                        row[j] = row[i + 1];
                        row[i + 1] = t;
                    }
                }
            }

            return res;
        }
    }

    class Solution2 {
        public int minSwapsCouples(int[] row) {
            int ret = 0;
            int n = row.length;
            int[] map = new int[n];
            for (int i = 0; i < n; i++)
                map[row[i]] = i;//记录数字出现的位置

            for (int i = 0; i < n; i += 2) {
                int a = row[i];
                int b = row[i + 1];
                if (a / 2 != b / 2) {
                    int pairValue = a % 2 == 0 ? a + 1 : a - 1;
                    int pairIndex = map[pairValue];
                    map[b] = pairIndex;
                    row[pairIndex] = b;
                    ret++;
                }
            }

            return ret;
        }

    }
}

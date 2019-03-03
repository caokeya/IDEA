package com.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
8 间牢房排成一排，每间牢房不是有人住就是空着。
每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
    如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
    否则，它就会被空置。
（请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
示例 1：
输入：cells = [0,1,0,1,1,0,0,1], N = 7
输出：[0,0,1,1,0,0,0,0]
解释：
下表概述了监狱每天的状况：
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
示例 2：
输入：cells = [1,0,0,1,0,0,1,0], N = 1000000000
输出：[0,0,1,1,1,1,1,0]
 */
public class _957_Prison_Cells_After_N_Days_N天后的牢房 {
    /*
    We record all seen states.
    Be careful,
    we need transform array to string as the key,
    otherwise it use the reference.
    */
    class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            Map<String, Integer> seen = new HashMap<>();
            while (N > 0) {
                int[] cells2 = new int[8];
                seen.put(Arrays.toString(cells), N--);
                for (int i = 1; i < 7; ++i)
                    cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
                cells = cells2;
                if (seen.containsKey(Arrays.toString(cells))) {
                    N %= seen.get(Arrays.toString(cells)) - N;
                }
            }
            return cells;
        }
    }
    /*
    I tried to find the pattern of the loop.
    Well, the length of loop can be 1, 7, or 14.
    
    So once we enter the loop, every 14 steps must be the same state.
    
    The length of cells is even,
    so for any state, we can find a previous state.
    So all states are in a loop.
     */
    class Solution2 {
        public int[] prisonAfterNDays(int[] cells, int N) {
               for (N = (N - 1) % 14 + 1; N > 0; --N) {
                   int[] cells2 = new int[8];
                   for (int i = 1; i < 7; ++i)
                       cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
                   cells = cells2;
               }
               return cells;
           }
       }
}

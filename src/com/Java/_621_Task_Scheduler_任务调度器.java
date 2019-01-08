package src.com.Java;

import java.util.Arrays;

/*
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
你需要计算完成所有任务所需要的最短时间。
示例 1：
输入: tasks = ["A","A","A","B","B","B"], n = 2
输出: 8
执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
A,A,A,A,B,B,B,B,C,C,C,D   n = 4
A B C D #
A B C # #
A B C # #
A B # # #
 */
public class _621_Task_Scheduler_任务调度器 {
    /*
    (c[25] - 1) * (n + 1) + 25 - i  is frame size
    when inserting chars, the frame might be "burst", then tasks.length takes precedence
    when 25 - i > n, the frame is already full at construction, the following is still valid.
    */
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] c = new int[26];
            for (char t : tasks) {
                c[t - 'A']++;
            }
            Arrays.sort(c);
            int i = 25;
            while (i >= 0 && c[i] == c[25])
                i--;
            return Math.max(tasks.length, (c[25] - 1) * (n + 1) + (25 - i));
        }
    }
}

package src.com.Java;

import java.util.List;
import java.util.Stack;

/*
给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。
每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。
日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。
函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。
示例 1:
输入:
n = 2
logs = 
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
输出:[3, 4]
说明：
函数 0 在时刻 0 开始，在执行了  2个时间单位结束于时刻 1。
现在函数 0 调用函数 1，函数 1 在时刻 2 开始，执行 4 个时间单位后结束于时刻 5。
函数 0 再次在时刻 6 开始执行，并在时刻 6 结束运行，从而执行了 1 个时间单位。
所以函数 0 总共的执行了 2 +1 =3 个时间单位，函数 1 总共执行了 4 个时间单位。
 */
public class _636_Exclusive_Time_of_Functions_函数的独占时间 {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<Integer>();
            int pre = 0;
            for (String log : logs) {
                String[] arr = log.split(":");
                if (arr[1].equals("start")) {
                    if (!stack.isEmpty()) {
                        res[stack.peek()] += Integer.parseInt(arr[2]) - pre;
                    }
                    stack.push(Integer.parseInt(arr[0]));
                    pre = Integer.parseInt(arr[2]);
                } else {
                    res[stack.pop()] += Integer.parseInt(arr[2]) - pre + 1;
                    pre = Integer.parseInt(arr[2]) + 1;
                }
            }
            return res;
        }
    }
}

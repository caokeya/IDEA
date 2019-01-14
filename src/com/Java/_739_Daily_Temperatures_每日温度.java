package src.com.Java;

import java.util.Stack;

/*
根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 */
public class _739_Daily_Temperatures_每日温度 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] stack = new int[temperatures.length];
            int top = -1;
            int[] ret = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                    int idx = stack[top--];
                    ret[idx] = i - idx;
                }
                stack[++top] = i;
            }
            return ret;
        }
    }

    /*
    用一个stack来存还没有solve的数的index，这些数还没有被solve，说明还没有找到比它们大的，所以stack里的数一定是non-increasing的。
    每进来一个新的数， 我们就把这个数和stack里面的数作对比， 比stack的数大，就pop一个。再接着和下一个数作对比， 一直到比stack里的数小为止。
    */
    class Solution2 {
        public int[] dailyTemperatures(int[] T) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                while (!stack.empty() && T[stack.peek()] < T[i]) {
                    int idx = stack.pop();
                    res[idx] = i - idx;
                }
                stack.push(i);
            }
            return res;
        }
    }
}

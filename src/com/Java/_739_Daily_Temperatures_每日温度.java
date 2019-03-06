package src.com.Java;

import java.util.Stack;

/*
根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 */
public class _739_Daily_Temperatures_每日温度 {
    /*
         思路就是从后往前走， 判断i+1位是否比自己小， 如果是的话， 那么下一个比自己大的数至少都在res[i + 1] + i + 1的位置上了。 
         从而就skip了中间的很多数。如果T[j]比自己小， 且res[j] == 0， 就说明后面都不会有比j大的数了， 自然也不会有比i大的数了。res[i] = 0
     */
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int len = T.length;
            int[] res = new int[len];
            for (int i = len - 2; i >= 0; i--) {
                int idx = i + 1;
                while (T[idx] <= T[i]) {

                    if (res[idx] == 0) {
                        break;
                    }
                    idx = idx + res[idx];
                }
                res[i] = T[idx] > T[i] ? idx - i : 0;
            }
            return res;
        }
    }
    
    /*
          用一个stack来存还没有solve的数的index，这些数还没有被solve，说明还没有找到比它们大的，所以stack里的数一定是non-increasing的。
          每进来一个新的数， 我们就把这个数和stack里面的数作对比， 比stack的数大，就pop一个。再接着和下一个数作对比， 一直到比stack里的数小为止。 
     */
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

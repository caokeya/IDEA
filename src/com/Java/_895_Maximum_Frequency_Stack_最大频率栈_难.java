package src.com.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
FreqStack 有两个函数：
    push(int x)，将整数 x 推入栈中。
    pop()，它移除并返回栈中出现最频繁的元素。
        如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
示例：
输入：
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
输出：[null,null,null,null,null,null,null,5,7,5,4]
解释：
执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
pop() -> 返回 5，因为 5 是出现频率最高的。
栈变成 [5,7,5,7,4]。
pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
栈变成 [5,7,5,4]。
pop() -> 返回 5 。
栈变成 [5,7,4]。
pop() -> 返回 4 。
栈变成 [5,7]。
 */
public class _895_Maximum_Frequency_Stack_最大频率栈_难 {
    class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxfreq;

        public FreqStack() {
            freq = new HashMap();
            group = new HashMap();
            maxfreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxfreq)
                maxfreq = f;

            group.computeIfAbsent(f, z -> new Stack()).push(x);
        }

        public int pop() {
            int x = group.get(maxfreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxfreq).size() == 0)
                maxfreq--;
            return x;
        }
    }
    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     */
}

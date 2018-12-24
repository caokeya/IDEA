package src.com.Java;

import java.util.Stack;

/*
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
    push(x) -- 将元素 x 推入栈中。
    pop() -- 删除栈顶的元素。
    top() -- 获取栈顶元素。
    getMin() -- 检索栈中的最小元素。
示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 */
public class _155_Min_Stack_最小栈 {
    class MinStack {
        /*
         * initialize your data structure here.
         */
        long min;
        Stack<Long> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {

            if (stack.isEmpty()) {
                stack.push(0L);
                min = x;
            } else {
                stack.push(x - min);
                if (x < min) {
                    min = x;
                }
            }
        }

        public void pop() {
            long x = stack.pop();
            if (x < 0)
                min = min - x;
        }

        public int top() {

            long x = stack.peek();
            if (x < 0)
                return (int) min;
            else
                return (int) (x + min);
        }

        public int getMin() {
            return (int) min;
        }
    }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}

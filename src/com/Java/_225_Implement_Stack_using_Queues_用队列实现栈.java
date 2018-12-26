package src.com.Java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 使用队列实现栈的下列操作：
 push(x) -- 元素 x 入栈
 pop() -- 移除栈顶元素
 top() -- 获取栈顶元素
 empty() -- 返回栈是否为空
*/
public class _225_Implement_Stack_using_Queues_用队列实现栈 {
    class MyStack {
        Deque<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (empty()) throw new IndexOutOfBoundsException("Empty stack");
            return queue.removeLast();
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (empty()) throw new IndexOutOfBoundsException("Empty stack");
            return queue.getLast();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    class MyStack2 {
        Queue<Integer> queue = new LinkedList();

        /**
         * Initialize your data structure here.
         */
        public MyStack2() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.size() == 0;
        }
    }


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}

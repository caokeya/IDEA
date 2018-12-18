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
        Queue<Integer> myStackIn;
        Queue<Integer> myStackOut;

        /**
         * Initialize your data structure here.
         */
        public MyStack2() {
            myStackIn = new PriorityQueue<>();
            myStackOut = new PriorityQueue<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            myStackIn.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int result;
            while (myStackIn.size() != 1) {
                myStackOut.add(myStackIn.poll());
            }
            result = myStackIn.poll();
            while (myStackOut.peek() != null) {
                myStackIn.add(myStackOut.poll());
            }
            return result;
        }

        /**
         * Get the top element.
         */
        public int top() {
            int result;
            while (myStackIn.size() != 1) {
                myStackOut.add(myStackIn.poll());
            }
            result = myStackIn.peek();
            while (myStackOut.peek() != null) {
                myStackIn.add(myStackOut.poll());
            }
            return result;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return myStackIn.peek() == null;
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

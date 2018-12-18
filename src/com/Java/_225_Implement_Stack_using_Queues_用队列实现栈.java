package src.com.Java;

import java.util.LinkedList;
import java.util.Queue;

/** 
* @author  suzw
* @version 创建时间：2018年9月19日 上午10:31:10 
* 类说明 
* Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:
MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, 
size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list 
or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an 
empty stack).
*/
public class _225_Implement_Stack_using_Queues_用队列实现栈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class MyStack {
		Queue<Integer> queue;
	    /** Initialize your data structure here. */
	    public MyStack() {
	        queue = new LinkedList<Integer>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	    	//先加入队列的末尾，再将队列颠倒顺序[最后添加的一个元素放在队首]
	        queue.add(x);
	        //如[1],add2->[1,2]-》 [2,1],add3->[2,1,3]->[1,3,2]->[3,2,1]
	        for (int i = 0; i < queue.size()-1; i++) {
				queue.add(queue.poll());
			}
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        return (int) queue.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        return (int) queue.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
}

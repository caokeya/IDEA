package src.com.Java;

import java.util.Stack;

/** 
* @author  suzw
* @version 创建时间：2018年9月20日 上午10:44:38 
* 类说明 
* Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, 
size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using 
a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called 
on an empty queue).
*/
public class _232_Implement_Queue_Using_Stacks_使用栈来实现队列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class MyQueue {

	    Stack<Integer> stack1;
	    Stack<Integer> stack2;
	    /** Initialize your data structure here. */
	    public MyQueue() {
	        stack1=new Stack<Integer>();
	        stack2=new Stack<Integer>();
	        
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	       
	        if(stack1.isEmpty()){
	            stack1.push(x);
	        }else{
	            while(!stack1.isEmpty()){
	                stack2.push(stack1.pop());
	            }
	            stack1.push(x);
	            
	            while(!stack2.isEmpty()){
	                stack1.push(stack2.pop());
	            }
	        }
	        
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        return stack1.pop();
	        
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        return stack1.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stack1.isEmpty();
	    }
	}

	class MyQueue2 {
		//Stack<Integer> stack = new LinkedList<Integer>();
		Stack<Integer> stackIn;
		Stack<Integer> stackOut;
		/** Initialize your data structure here. */
	    public MyQueue2() {
	        stackIn = new Stack<Integer>();
	        stackOut = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	    	/*
	    	while (!stackOut.isEmpty()) {
				stackIn.push(stackOut.pop());
			}
			*/
	        stackIn.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    
	    public int pop() {
	    	peek();
	        return (int) stackOut.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	if(stackOut.isEmpty())
		    	while(!stackIn.isEmpty())
		        	stackOut.push(stackIn.pop());
	        return (int) stackOut.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stackIn.isEmpty() && stackOut.isEmpty();
	    }
	}
}

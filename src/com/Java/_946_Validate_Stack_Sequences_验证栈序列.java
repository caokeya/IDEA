package com.Java;

import java.util.Stack;

/*
给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
示例 1：
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
示例 2：
输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
 */
public class _946_Validate_Stack_Sequences_验证栈序列 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int pushedNum : pushed) {
                stack.push(pushedNum);
                while (!stack.isEmpty() && stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                }
            }
            return stack.isEmpty();
        }
    }

    class Solution2 {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            if (pushed == null || popped == null || pushed.length != popped.length)
                return false;
            if (pushed.length == 0)
                return true;
            int n = pushed.length;
            int j = 0;
            for (int i = 0; i < n; i++) {
                stack.push(pushed[i]);
                while (j < n && !stack.empty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            while (j < n && !stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

            return (stack.empty());
        }
    }
}

package src.com.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个整数数组 asteroids，表示在同一行的行星。
对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
示例 1:
输入: 
asteroids = [5, 10, -5]
输出: [5, 10]
解释: 
10 和 -5 碰撞后只剩下 10。 5 和 10 永远不会发生碰撞。
示例 2:
输入: 
asteroids = [8, -8]
输出: []
解释: 
8 和 -8 碰撞后，两者都发生爆炸。
示例 3:
输入: 
asteroids = [10, 2, -5]
输出: [10]
解释: 
2 和 -5 发生碰撞后剩下 -5。10 和 -5 发生碰撞后剩下 10。
示例 4:
输入: 
asteroids = [-2, -1, 1, 2]
输出: [-2, -1, 1, 2]
解释: 
-2 和 -1 向左移动，而 1 和 2 向右移动。
由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 */
public class _735_Asteroid_Collision_行星碰撞 {
    /*
     1）栈为空； 2）栈顶为负数（此时栈内元素已不会影响到后面）；3）栈顶元素和当前数字同号
           需要特殊处理的是栈顶为正数，当前数字为负数，假设分别为s[top]和num，s[top]>=-num && s[top] > 0时栈顶出栈，相等的情况需要单独处理
     */
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            int[] arr = asteroids;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    stack.push(arr[i]);
                } else {
                    while (!stack.isEmpty() && Math.abs(arr[i]) > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        list.add(arr[i]);
                    } else if (stack.peek() == Math.abs(arr[i])) {
                        stack.pop();
                    }
                }
            }

            for (Integer t : stack) {
                list.add(t);
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    class Solution2 {

        public int[] asteroidCollision(int[] a) {

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < a.length; i++) {
                if (stack.isEmpty() || a[i] > 0) {
                    stack.push(a[i]);
                    continue;
                }

                while (true) {
                    int prev = stack.peek();
                    if (prev < 0) {
                        stack.push(a[i]);
                        break;
                    }

                    if (Math.abs(a[i]) == prev) {
                        stack.pop();
                        break;
                    }

                    if (Math.abs(a[i]) < prev) {
                        break;
                    }

                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(a[i]);
                        break;
                    }

                }
            }

            int[] res = new int[stack.size()];
            // 这里要倒着输出！！！
            for (int i = stack.size() - 1; i >= 0; i--) {
                res[i] = stack.pop();
            }

            return res;

        }
    }
}

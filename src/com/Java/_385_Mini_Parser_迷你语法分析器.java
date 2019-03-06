package src.com.Java;

import java.util.List;
import java.util.Stack;

/*
给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
列表中的每个元素只可能是整数或整数嵌套列表
提示：你可以假定这些字符串都是格式良好的：
    字符串非空
    字符串不包含空格
    字符串只包含数字0-9, [, - ,, ]
示例 2：
给定 s = "[123,[456,[789]]]",
返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
1. 一个 integer 包含值 123
2. 一个包含两个元素的嵌套列表：
    i.  一个 integer 包含值 456
    ii. 一个包含一个元素的嵌套列表
         a. 一个 integer 包含值 789
 */
public class _385_Mini_Parser_迷你语法分析器 {
    /**
     * // This is the interface that allows for creating nested lists. // You should
     * not implement it, or speculate about its implementation
     */
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger();

        // Constructor initializes a single integer.
        public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    class Solution {
        public NestedInteger deserialize(String s) {
            if (!s.contains("[")) {
                return new NestedInteger(Integer.valueOf(s));
            }
            Stack<NestedInteger> stack = new Stack<>();
            int num = 0;
            NestedInteger res = null;
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '[') {
                    stack.add(new NestedInteger());
                    j = i + 1;
                } else if (ch == ']') {
                    if (s.charAt(i - 1) != ']' && s.charAt(i - 1) != '[') {
                        stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(j, i))));
                        j = i + 1;

                    }

                    res = stack.pop();
                    if (!stack.isEmpty())
                        stack.peek().add(res);

                } else if (ch == ',') {
                    if (s.charAt(i - 1) != ']') {
                        stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(j, i))));
                    }
                    j = i + 1;
                }
            }
            return res;

        }
    }
}

package com.company;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class _071_Simplify_Path_简化路径 {
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> stack = new LinkedList<>();
            Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
            String[] paths = path.split("/");
            for (String p : paths) {
                if (p.equals("..") && !stack.isEmpty()) {
                    stack.removeLast();
                } else if (!skip.contains(p)) {
                    stack.addLast(p);
                }
            }
            if (stack.isEmpty())
                return "/"; // expt

            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                res.insert(0, "/" + stack.removeLast());
            }
            return res.toString();
        }
    }
}

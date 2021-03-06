package src.com.Java;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
/*
给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
例如，
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
边界情况:
    你是否考虑了 路径 = "/../" 的情况？
    在这种情况下，你需返回 "/" 。
    此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
    在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 */
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

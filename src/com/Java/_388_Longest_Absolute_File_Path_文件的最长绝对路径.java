package src.com.Java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
假设我们以下述方式将我们的文件系统抽象成一个字符串:
字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示:
dir
    subdir1
    subdir2
        file.ext
目录 dir 包含一个空的子目录 subdir1 和一个包含一个文件 file.ext 的子目录 subdir2 。
字符串 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 表示:
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
给定一个以上述格式表示文件系统的字符串，返回文件系统中文件的最长绝对路径的长度。 如果系统中没有文件，返回 0。
 */
public class _388_Longest_Absolute_File_Path_文件的最长绝对路径 {
    class Solution {
        public int lengthLongestPath(String input) {
            String[] elements = input.split("\n");
            int result = 0;
            Deque<int[]> deque = new LinkedList<>();
            for (String element : elements) {
                int indent = countIndent(element);//'\t'的个数
                int size = element.length() - indent;//除去'\t'的长度
                while (!deque.isEmpty() && deque.getLast()[0] >= indent) {//如果更底层则去除最后一个
                    deque.removeLast();
                }
                if (deque.isEmpty()) {
                    deque.addLast(new int[]{indent, size});
                } else {
                    deque.addLast(new int[]{indent, size + deque.getLast()[1] + 1});//+1是因为\n\t\t\tfile2.ext会多一个'\'
                }
                if (element.contains(".")) {
                    result = Math.max(result, deque.getLast()[1]);
                }
            }
            return result;
        }

        private int countIndent(String element) {
            int i = 0;
            while (element.charAt(i) == '\t') {
                i++;
            }
            return i;
        }
    }
}

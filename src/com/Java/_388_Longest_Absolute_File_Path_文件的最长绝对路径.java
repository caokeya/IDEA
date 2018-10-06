package src.com.Java;

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
            Stack<Integer> stack = new Stack<Integer>();
            String[] split = input.split("\n");
            stack.push(0); // dummy length;
            int maxLevel = 0;

            for (String str : split) {
                int numOfTabs = str.lastIndexOf("\t") + 1; // this +1 because array index starts from 0;

                int level = numOfTabs + 1; // one \t is level 1 \t\t is level2 so on..

                while (!stack.isEmpty() && level < stack.size()) {
                    stack.pop();
                }

                int currLevel = stack.peek() + str.length() - numOfTabs + 1; // subtract the tabs , this +1 is for
                                                                             // adding the "/" after this directory;
                stack.push(currLevel);
                if (str.contains(".")) { // means u have reached a file
                    int currStrLevel = currLevel - 1; // -1 for removing previously adding +1
                    if (currStrLevel > maxLevel) {
                        maxLevel = currStrLevel;
                    }
                }

            }
            return maxLevel;
        }
    }
}

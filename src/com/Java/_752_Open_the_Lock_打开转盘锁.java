package com.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
示例 1:
输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
示例 2:
输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。
示例 3:
输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。
示例 4:
输入: deadends = ["0000"], target = "8888"
输出：-1
 */
public class _752_Open_the_Lock_打开转盘锁 {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> begin = new HashSet<>();
            Set<String> end = new HashSet<>();
            Set<String> deads = new HashSet<>(Arrays.asList(deadends));
            begin.add("0000");
            end.add(target);

            int level = 0;
            Set<String> temp;
            while (!begin.isEmpty() && !end.isEmpty()) {
                //通过总是选择一个较小的集合，这个过程可以稍微减少一点(因为在这个问题中，两边的规模是相似的)时间复杂度和内存复杂度
                //交换begin和end让集合从两端向中间靠近，直到有重合
                if (begin.size() > end.size()) {
                    temp = begin;
                    begin = end;
                    end = temp;
                }
                temp = new HashSet<>(); // temp用来做下一次的begin或者end
                for (String str : begin) {
                    if (end.contains(str)) {
                        return level;
                    }
                    if (deads.contains(str)) {
                        continue;
                    }

                    deads.add(str);
                    for (int i = 0; i < 4; i++) {
                        char c = str.charAt(i);
                        String next1 = str.substring(0, i) + (c == '9' ? 0 : c - '0' + 1)
                                + str.substring(i + 1, str.length());
                        String next2 = str.substring(0, i) + (c == '0' ? 9 : c - '0' - 1)
                                + str.substring(i + 1, str.length());
                        if (!deads.contains(next1))
                            temp.add(next1);
                        if (!deads.contains(next2))
                            temp.add(next2);
                    }
                }
                level++;

                begin = temp;
            }

            return -1;
        }
    }
}
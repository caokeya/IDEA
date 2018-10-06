package src.com.Java;
/*
给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字。
示例：
输入:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6
输出:
6
 */
public class _390_Elimination_Game_消除游戏 {
    /**
    When will head be updated?
    1. if we move from left
    2. if we move from right and the total remaining number % 2 == 1
        like 2 4 6 8 10, we move from 10, we will take out 10, 6 and 2, head is deleted and move to 4
        like 2 4 6 8 10 12, we move from 12, we will take out 12, 8, 4, head is still remaining 2
    Then we find a rule to update our head.

    举例：
    n为偶数：
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
      2   4   6   8   10    12    14    16
      2       6       10          14
              6                   14
              6
                   
    n为奇数：            
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
      2   4   6   8   10    12    14
          4       8         12
                  8
    */
    public class Solution {
        public int lastRemaining(int n) {
            boolean left = true; // 是否从左向右遍历
            int remains = n;     // 剩余的数字个数
            int step = 1;        // 原来的head向前走多少步到达新的head位置。因为数组长度每次都砍半，所以跨的步伐要在原来基础上乘以2，看范例理解
            int head = 1;        // 每次循环后数组的第一个数字
            while (remains > 1) {
                if (left || remains % 2 == 1) {
                    head += step;
                }
                remains /= 2;
                step *= 2;
                left = !left;
            }
            return head;
        }
    }
}

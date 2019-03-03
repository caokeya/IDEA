package com.Java;

/*
给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
示例:
输入:
letters = ["c", "f", "j"]
target = "a"
输出: "c"
输入:
letters = ["c", "f", "j"]
target = "c"
输出: "f"
输入:
letters = ["c", "f", "j"]
target = "d"
输出: "f"
输入:
letters = ["c", "f", "j"]
target = "g"
输出: "j"
输入:
letters = ["c", "f", "j"]
target = "j"
输出: "c"
输入:
letters = ["c", "f", "j"]
target = "k"
输出: "c"
 */
public class _744_Find_Smallest_Letter_Greater_Than_Target_寻找比目标字母大的最小字母 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length;

            // hi starts at 'n' rather than the usual 'n - 1'.
            // It is because the terminal condition is 'lo < hi' and if hi starts from 'n - 1',
            // we can never consider value at index 'n - 1'
            int lo = 0, hi = n;

            // Terminal condition is 'lo < hi', to avoid infinite loop when target is smaller than the first element
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (letters[mid] > target)
                    hi = mid;
                else
                    lo = mid + 1; // a[mid] <= x
            }
            // Because lo can end up pointing to index 'n', in which case we return the first element
            return letters[lo % n];
        }
    }

    class Solution2 {
        public char nextGreatestLetter(char[] letters, char target) {
            int start = 0;
            int end = letters.length - 1;
            while (start < end - 1) {
                int mid = (start + end) / 2;
                if (target < letters[mid])
                    end = mid;
                else if (target >= letters[mid])
                    start = mid;
            }
            
            if (target >= letters[end])
                return letters[0];
            else if (target >= letters[start])
                return letters[end];
            else
                return letters[start];
        }
    }
}

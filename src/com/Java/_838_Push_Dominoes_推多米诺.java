package com.Java;

/*
一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
在开始时，我们同时把一些多米诺骨牌向左或向右推。
每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；
如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
返回表示最终状态的字符串。
示例 1：
输入：".L.R...LR..L.."
输出："LL.RR.LLRRLL.."
示例 2：
输入："RR.L"
输出："RR.L"
说明：第一张多米诺骨牌没有给第二张施加额外的力。
 */
public class _838_Push_Dominoes_推多米诺 {
    class Solution {
        public String pushDominoes(String dominoes) {
            if (dominoes == null || dominoes.length() == 0) {
                return null;
            }
            char[] charArr = dominoes.toCharArray();
            int curPos = 0;
            int len = dominoes.length();
            char startChar = '.';
            int count = 0;
            while (curPos < len) {
                char curChar = charArr[curPos];
                // 当前多米诺不是直立状态
                if (curChar != '.') {
                    // 有两种情况
                    // 之前是直立状态
                    if (count > 0) {
                        // 如果当前状态是l，那么更改之前的直立状态的多米诺为l，中间的修改为.
                        if (curChar == 'L') {
                            int changeCount = count / 2;
                            // 如果最接近的元素是r那么就修改一半的元素为l
                            // 如果仍然是直立，那么就修改所有的元素为l
                            if (charArr[curPos - 1] == 'R') {
                                for (int i = 0; i < changeCount; i++) {
                                    charArr[curPos - 1 - i] = 'L';
                                }
                                if (count % 2 == 1) {
                                    charArr[curPos - 1 - changeCount] = '.';
                                }
                            } else {
                                for (int i = 0; i < count; i++) {
                                    charArr[curPos - 1 - i] = 'L';
                                }
                            }
                        }
                    }
                    count = 0;
                    startChar = curChar;
                } else {
                    // 当前多米诺是直立状态
                    // 如果之前的状态是r，那么更改当前直立多米诺的状态为r
                    if (startChar == 'R') {
                        charArr[curPos] = 'R';
                    }
                    count++;
                }
                curPos++;
            }
            return new String(charArr);
        }
    }

    class Solution2 {
        public String pushDominoes(String dominoes) {
            char[] a = dominoes.toCharArray();
            int left = -1;
            int right = -1;

            for (int i = 0; i <= a.length; i++) {
                if (i == a.length || a[i] == 'R') {
                    if (right > left) {
                        while (right < i) {
                            a[right++] = 'R';
                        }
                    }
                    right = i;
                } else if (a[i] == 'L') {
                    if (left > right || (right == -1 && left == -1)) {
                        while (left < i) {
                            a[++left] = 'L';
                        }
                        left = i;
                    } else {
                        left = i;
                        int lo = right + 1;
                        int hi = left - 1;
                        while (lo < hi) {
                            a[lo++] = 'R';
                            a[hi--] = 'L';
                        }
                    }
                }
            }
            return new String(a);
        }

    }
}

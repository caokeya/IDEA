package src.com.Java;
/*
给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
示例 1:
输入: S = "rabbbit", T = "rabbit"
输出: 3
解释:
如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
(上箭头符号 ^ 表示选取的字母)
rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
 */
public class _115_Distinct_Subsequences_不同的子序列_难 {
    class Solution {
        public int numDistinct(String S, String T) {
            // array creation
            int[][] mem = new int[T.length() + 1][S.length() + 1];

            // filling the first row: with 1s
            for (int j = 0; j <= S.length(); j++) {
                mem[0][j] = 1;
            }

            /*
            if the current character in S doesn't equal to current character T,
                then we have the same number of distinctsubsequences as we had without the new character.
            if the current character in S equal to the current character T,
                then the distinct number of subsequences: the number we had before plus the distinct number of
                subsequences we had with less longer T and less longer S.
            S: [acdabefbc] and T: [ab]
                    first we check with a:
                               *  *
                          S = [acdabefbc]
                    mem[1] = [0111222222]

                    then we check with ab:
                                   *  * ]
                          S = [acdabefbc]
                    mem[1] = [0111222222]
                    mem[2] = [0000022244]
            */
            for (int i = 0; i < T.length(); i++) {
                for (int j = 0; j < S.length(); j++) {
                    if (T.charAt(i) == S.charAt(j)) {
                        mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                    } else {
                        mem[i + 1][j + 1] = mem[i + 1][j];
                    }
                }
            }
            return mem[T.length()][S.length()];
        }
    }
}

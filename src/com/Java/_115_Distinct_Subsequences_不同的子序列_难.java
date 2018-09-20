package src.com.Java;

public class _115_Distinct_Subsequences_不同的子序列_难 {
    class Solution {
        public int numDistinct(String S, String T) {
            // array creation
            int[][] mem = new int[T.length() + 1][S.length() + 1];

            // filling the first row: with 1s
            for (int j = 0; j <= S.length(); j++) {
                mem[0][j] = 1;
            }

            /**S: [acdabefbc] and T: [ab]

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

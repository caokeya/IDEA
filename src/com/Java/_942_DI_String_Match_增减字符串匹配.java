package src.com.Java;

/*
给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
    如果 S[i] == "I"，那么 A[i] < A[i+1]
    如果 S[i] == "D"，那么 A[i] > A[i+1]
示例 1：
输出："IDID"
输出：[0,4,1,3,2]
示例 2：
输出："III"
输出：[0,1,2,3]
示例 3：
输出："DDI"
输出：[3,2,0,1]
 */
public class _942_DI_String_Match_增减字符串匹配 {
    class Solution {
        public int[] diStringMatch(String S) {
            char[] cha = S.toCharArray();
            int N = cha.length;
            int min = 0;
            int max = N;
            int[] res = new int[N + 1];

            for (int i = 0; i < N; i++) {
                if (cha[i] == 'I') {
                    res[i] = min;
                    min++;
                } else if (cha[i] == 'D') {
                    res[i] = max;
                    max--;
                }
            }
            res[res.length - 1] = cha[N - 1] == 'i' ? min : max;        //for the last number in the array
            return res;
        }
    }
}

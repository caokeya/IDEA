package src.com.Java;

import java.util.Arrays;

/*
如果一个字符在字符串 S 中有且仅有出现一次，那么我们称其为独特字符。
例如，在字符串 S = "LETTER" 中，"L" 和 "R" 可以被称为独特字符。
我们再定义 UNIQ(S) 作为字符串 S 中独特字符的个数。
那么，在 S = "LETTER" 中， UNIQ("LETTER") =  2。
对于给定字符串 S，计算其所有非空子串的独特字符的个数，即 UNIQ(substring)。
如果出现两个或者多个相同的子串，将其认为是不同的两个子串。
考虑到答案可能会非常大，规定返回格式为：结果 mod 10 ^ 9 + 7。
示例 1:
输入: "ABC"
输出: 10
解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
     其中，每一个子串都由独特字符构成。
     所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
示例 2:
输入: "ABA"
输出: 8
解释: 除了子串 UNIQ('ABA') = 1，其余与示例1相同。
 */
public class _828_Unique_Letter_String_独特字符串_难 {
    /*
    Think about string "XAXAXXAX" and focus on making the second "A" a unique character.
    We can take "XA(XAXX)AX" and between "()" is our substring.
    We can see here, to make the second "A" counted as a uniq character, we need to:
        insert "(" somewhere between the first and second A
        insert ")" somewhere between the second and third A
    For step 1 we have "A(XA" and "AX(A", 2 possibility.
    For step 2 we have "A)XXA", "AX)XA" and "AXX)A", 3 possibilities.
    So there are in total 2 * 3 = 6 ways to make the second A a unique character in a substring.
    In other words, there are only 6 substring, in which this A contribute 1 point as unique string.

    index[26][2] record last two occurrence index for every upper characters.
    Initialise all values in index to -1.
    Loop on string S, for every character c, update its last two occurrence index to index[c].
    Count when loop. For example, if "A" appears twice at index 3, 6, 9 seperately, we need to count:
        For the first "A": (6-3) * (3-(-1))"
        For the second "A": (9-6) * (6-3)"
        For the third "A": (N-9) * (9-6)"
     */
    public int uniqueLetterString(String S) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i)
            Arrays.fill(index[i], -1);
        int res = 0;
        int N = S.length();
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < N; ++i) {
            int c = S.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c] = new int[]{index[c][1], i};
        }
        for (int c = 0; c < 26; ++c)
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        return res;
    }

}

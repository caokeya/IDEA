package src.com.Java;

/*
有时候人们会用额外的字母来表示额外的情感，比如 "hello" -> "heeellooo", "hi" -> "hiii"。
我们将连续的相同的字母分组，并且相邻组的字母都不相同。我们将一个拥有三个或以上字母的组定义为扩张状态（extended），
如第一个例子中的 "e" 和" o" 以及第二个例子中的 "i"。 此外，"abbcccaaaa" 将有分组 "a" , "bb" , "ccc" , "dddd"；其中 "ccc" 和 "aaaa" 处于扩张状态。
对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
我们允许选择一个字母组（如包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
注意，我们不能将一个只包含一个字母的字母组，如 "h"，扩张到一个包含两个字母的组，如 "hh"；所有的扩张必须使该字母组变成扩张状态（至少包含三个字母）。
输入一组单词，输出其中可扩张的单词数量。
示例：
输入： 
S = "heeellooo"
words = ["hello", "hi", "helo"]
输出：1
解释：
我们能通过扩张"hello"的"e"和"o"来得到"heeellooo"。
我们不能通过扩张"helo"来得到"heeellooo"因为"ll"不处于扩张状态。
 */
public class _809_Expressive_Words_情感丰富的文字 {
    class Solution {
        public int expressiveWords(String S, String[] words) {
            if (words == null)
                return 0;
            int ret = 0;
            for (int i = 0; i < words.length; i++) {
                if (check(S, words[i]))
                    ret++;
            }
            return ret;
        }

        public boolean check(String S, String W) {

            int n = S.length(), m = W.length(), j = 0;
            for (int i = 0; i < n; i++) {
                if (j < m && S.charAt(i) == W.charAt(j))
                    j++;
                else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i - 2))
                    ;
                else if (i > 0 && i < n - 1 && S.charAt(i - 1) == S.charAt(i) && S.charAt(i) == S.charAt(i + 1))
                    ;
                else
                    return false;
            }
            return j == m;
        }
    }
}

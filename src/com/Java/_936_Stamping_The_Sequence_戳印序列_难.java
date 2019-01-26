package src.com.Java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
你想要用小写字母组成一个目标字符串 target。 
开始的时候，序列由 target.length 个 '?' 记号组成。而你有一个小写字母印章 stamp。
在每个回合，你可以将印章放在序列上，并将序列中的每个字母替换为印章上的相应字母。你最多可以进行 10 * target.length  个回合。
举个例子，如果初始序列为 "?????"，而你的印章 stamp 是 "abc"，那么在第一回合，你可以得到 "abc??"、"?abc?"、"??abc"。
（请注意，印章必须完全包含在序列的边界内才能盖下去。）
如果可以印出序列，那么返回一个数组，该数组由每个回合中被印下的最左边字母的索引组成。如果不能印出序列，就返回一个空数组。
例如，如果序列是 "ababc"，印章是 "abc"，那么我们就可以返回与操作 "?????" -> "abc??" -> "ababc" 相对应的答案 [0, 2]；
另外，如果可以印出序列，那么需要保证可以在 10 * target.length 个回合内完成。任何超过此数字的答案将不被接受。
示例 1：
输入：stamp = "abc", target = "ababc"
输出：[0,2]
（[1,0,2] 以及其他一些可能的结果也将作为答案被接受）
示例 2：
输入：stamp = "aabcaca", target = "abca"
输出：[3,0,1]
 */
public class _936_Stamping_The_Sequence_戳印序列_难 {
    /*
    我们将遍历整个目标字符串，以查找是否存在任何等于Stamp的子字符串。
    然后用*替换整个子字符串。您可以在步骤1中看到，我们将子字符串abc替换为***。然后我们继续做同样的事情。
    在步骤2中，您将发现我们将子字符串*bc替换为***。*可以匹配任何字符，因为*将被下一个戳记覆盖。
    最后得到结果并输出相反的结果。当星号等于target.length()时，我们将返回结果。
    如果在一次扫描中，我们甚至不能用*替换一个子字符串，直接返回空
     */
    class Solution {
        public int[] movesToStamp(String stamp, String target) {
            char[] S = stamp.toCharArray();
            char[] T = target.toCharArray();
            List<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[T.length];
            int stars = 0;

            while (stars < T.length) {
                boolean doneReplace = false;
                for (int i = 0; i <= T.length - S.length; i++) {
                    if (!visited[i] && canReplace(T, i, S)) {
                        stars = doReplace(T, i, S.length, stars);
                        doneReplace = true;
                        visited[i] = true;
                        res.add(i);
                        if (stars == T.length) {
                            break;
                        }
                    }
                }
                if (!doneReplace) {
                    return new int[0];
                }
            }

            int[] resArray = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                resArray[i] = res.get(res.size() - i - 1);
            }
            return resArray;
        }

        private boolean canReplace(char[] T, int p, char[] S) {
            for (int i = 0; i < S.length; i++) {
                if (T[i + p] != '*' && T[i + p] != S[i]) {
                    return false;
                }
            }
            return true;
        }

        private int doReplace(char[] T, int p, int len, int count) {
            for (int i = 0; i < len; i++) {
                if (T[i + p] != '*') {
                    T[i + p] = '*';
                    count++;
                }
            }
            return count;
        }
    }
}

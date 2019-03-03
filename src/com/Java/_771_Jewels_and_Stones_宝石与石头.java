package com.Java;

import java.util.HashSet;

/*
 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
示例 1:
输入: J = "aA", S = "aAAbbbb"
输出: 3
示例 2:
输入: J = "z", S = "ZZ"
输出: 0
 */
public class _771_Jewels_and_Stones_宝石与石头 {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            char[] jewels = J.toCharArray();
            char[] stones = S.toCharArray();
            int count = 0;
            for (char stone : stones) {
                for (char jewel : jewels) {
                    if (stone == jewel)
                        count++;
                }
            }
            return count;
        }
    }

    class Solution2 {
        public int numJewelsInStones(String J, String S) {

            int count = 0;

            char[] j = J.toCharArray();
            char[] s = S.toCharArray();

            HashSet<Character> jSet = new HashSet<Character>();

            for (char c : j)
                jSet.add(c);

            for (char x : s)
                if (jSet.contains(x))
                    count++;

            return count;

        }
    }
}

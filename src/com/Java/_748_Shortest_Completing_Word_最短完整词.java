package com.Java;

/*
如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
示例 1：
输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
输出："steps"
说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
示例 2：
输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
输出："pest"
说明：有三个单词都符合完整词的定义，但是我们返回最先出现的单词。
 */
public class _748_Shortest_Completing_Word_最短完整词 {
    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            String licensePlatelow = licensePlate.toLowerCase();
            int[] charMap = new int[26];
            // Construct the character map
            for (int i = 0; i < licensePlatelow.length(); i++) {//记录目标词中各个字母的个数
                if (Character.isLetter(licensePlatelow.charAt(i)))
                    charMap[licensePlatelow.charAt(i) - 'a']++;
            }
            int minLength = Integer.MAX_VALUE;
            String result = null;
            for (int i = 0; i < words.length; i++) {
                String word = words[i].toLowerCase();
                if (matches(word, charMap) && word.length() < minLength) {
                    minLength = word.length();
                    result = words[i];
                }
            }
            return result;
        }

        private boolean matches(String word, int[] charMap) {
            int[] wordMap = new int[26];
            for (int i = 0; i < word.length(); i++) {//记录词典中各个字母的个数
                if (Character.isLetter(word.charAt(i)))
                    wordMap[word.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (charMap[i] != 0 && wordMap[i] < charMap[i])
                    return false;
            }
            return true;
        }
    }
}

package src.com.Java;

/*
给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母
你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
示例 1:
输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
输出: 16 
解释: 这两个单词为 "abcw", "xtfn"。
 */
public class _318_Maximum_Product_of_Word_Lengths_最大单词长度乘积 {
    public class Solution {
        public int maxProduct(String[] words) {
            int max = 0;
            int[] bytes = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                int val = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    val |= 1 << (words[i].charAt(j) - 'a');//记录各个单词出现的情况
                }
                bytes[i] = val;
            }
            for (int i = 0; i < bytes.length; i++) {
                for (int j = i + 1; j < bytes.length; j++) {
                    if ((bytes[i] & bytes[j]) == 0)//没有相同字母
                        max = Math.max(max, words[i].length() * words[j].length());
                }
            }
            return max;
        }
    }
}

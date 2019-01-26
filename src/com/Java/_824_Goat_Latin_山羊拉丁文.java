package src.com.Java;

import java.util.Arrays;
import java.util.HashSet;

/*
给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
山羊拉丁文的规则如下：
    如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
        例如，单词"apple"变为"applema"。
    如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
        例如，单词"goat"变为"oatgma"。
    根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
        例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
返回将 S 转换为山羊拉丁文后的句子。
示例 1:
输入: "I speak Goat Latin"
输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
示例 2:
输入: "The quick brown fox jumped over the lazy dog"
输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class _824_Goat_Latin_山羊拉丁文 {
    class Solution {
        public String toGoatLatin(String S) {
            String vowels = "aeiouAEIOU";
            StringBuilder sb = new StringBuilder();
            String[] arr = S.split(" ");
            for (int i = 0; i < arr.length; i++) {
                if (vowels.indexOf(arr[i].charAt(0)) >= 0)
                    arr[i] += "ma";
                else {
                    arr[i] = arr[i].substring(1, arr[i].length()) + arr[i].charAt(0) + "ma";
                }
                for (int j = 0; j <= i; j++) {
                    arr[i] += "a";
                }
                sb.append(arr[i] + " ");
            }
            return sb.toString().substring(0, sb.length() - 1);
        }
    }

    class Solution2 {
        public final Character[] vowelsList = new Character[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        HashSet<Character> vowels = new HashSet<Character>(Arrays.asList(vowelsList));

        public String toGoatLatin(String S) {
            if (S == null || S.length() == 0) {
                return "";
            }
            StringBuilder answer = new StringBuilder();
            int wordIndex = 1;
            for (String word : S.split(" ")) {
                if (wordIndex != 1) {
                    answer.append(" ");
                }
                char firstCharacter = word.charAt(0);
                if (vowels.contains(firstCharacter)) {
                    answer.append(word);
                } else {
                    answer.append(word.substring(1));
                    answer.append(firstCharacter);
                }
                answer.append("ma");
                for (int i = 0; i < wordIndex; i++) {
                    answer.append("a");
                }
                wordIndex++;
            }
            return answer.toString();
        }
    }
}

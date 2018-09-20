package src.com.Java;

public class _058_Length_of_Last_Word_最后一个单词的长度 {
    class Solution {
        public int lengthOfLastWord(String s) {
            return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
        }
    }
}

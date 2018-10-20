package src.com.Java;

/*
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
换句话说，第一个字符串的排列之一是第二个字符串的子串。
示例1:
输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
示例2:
输入: s1= "ab" s2 = "eidboaoo"
输出: False
 */
public class _567_Permutation_in_String_字符串的排列 {
    /*
         * 我们只需要创建一个长度为s1的滑动窗口，从s2的开始移动到结束。
         * 当一个字符从窗口的右侧移进来时，我们从地图中减去1个字符的计数。当一个字符从窗口的左边移出时，我们向该字符计数加1。
         * 因此，一旦我们看到地图上所有的0，即s1和滑动窗口子字符串之间的每个字符的数量相等，我们就知道答案是正确的。
     */
    public class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 > len2)
                return false;

            int[] count = new int[26];
            for (int i = 0; i < len1; i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            }
            if (allZero(count))
                return true;

            for (int i = len1; i < len2; i++) {
                count[s2.charAt(i) - 'a']--;
                count[s2.charAt(i - len1) - 'a']++;
                if (allZero(count))
                    return true;
            }

            return false;
        }

        private boolean allZero(int[] count) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0)
                    return false;
            }
            return true;
        }
    }
}

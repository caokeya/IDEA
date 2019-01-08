package src.com.Java;

/*
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
在执行上述操作后，找到包含重复字母的最长子串的长度。
注意:
字符串长度 和 k 不会超过 104。
示例 1:
输入:
s = "ABAB", k = 2
输出:
4
解释:
用两个'A'替换为两个'B',反之亦然。
 */
public class _424_Longest_Repeating_Character_Replacement_替换后的最长重复字符 {
    class Solution {
        public int characterReplacement(String s, int k) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int res = getResult(s, k);
            return res;
        }

        private int getResult(String s, int k) {
            int len = s.length();
            //  数频率
            int[] count = new int[26];
            int slow = 0, maxCount = 0, res = 0;
            for (int fast = 0; fast < len; fast++) {
                //  字母在count数组中的索引
                int idx = s.charAt(fast) - 'A';
                //  对应的字母频率+1
                count[idx]++;
                //  统计在当前位置下的最大频率
                maxCount = Math.max(maxCount, count[idx]);

                //  窗口开始收缩
                //  收缩条件：
                //      不同字母的数量超过k
                while (fast - slow + 1 - maxCount > k) {
                    count[s.charAt(slow) - 'A']--;
                    slow++;
                }
                res = Math.max(res, fast - slow + 1);
            }
            return res;
        }
    }
}

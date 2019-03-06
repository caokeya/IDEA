package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
注意:
假设字符串的长度不会超过 1010。
示例 1:
输入:
"abccccdd"
输出:
7
解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class _409_Longest_Palindrome_构造最长回文串 {
    class Solution {
        public int longestPalindrome(String s) {
            int[] cnt = new int[128];
            for (char c : s.toCharArray()) {
                cnt[c]++;
            }
            int res = 0;
            for (int i = 0; i < 128; i++) {
                res += cnt[i] % 2 == 0 ? cnt[i] : cnt[i] - 1;
                if (res % 2 == 0 && cnt[i] % 2 == 1) {
                    res++;
                }
            }
            return res;
        }
    }
    
    class Solution2 {
        public int longestPalindrome(String s) {
                Set<Character> set = new HashSet<>();
            
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(set.contains(c)){
                    set.remove(c);
                }else{
                    set.add(c);
                }
            }
            if(set.size() == 0) return s.length();
            return s.length() - set.size() + 1;
        }
    }
}

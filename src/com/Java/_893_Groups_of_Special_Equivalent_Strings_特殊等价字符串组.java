package com.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
你将得到一个字符串数组 A。
如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
一次移动包括选择两个索引 i 和 j，且 i％2 == j％2，并且交换 S[j] 和 S [i]。
现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
返回 A 中特殊等价字符串组的数量。
示例 1：
输入：["a","b","c","a","c","c"]
输出：3
解释：3 组 ["a","a"]，["b"]，["c","c","c"]
示例 2：
输入：["aa","bb","ab","ba"]
输出：4
解释：4 组 ["aa"]，["bb"]，["ab"]，["ba"]
示例 3：
输入：["abc","acb","bac","bca","cab","cba"]
输出：3
解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
示例 4：
输入：["abcd","cdab","adcb","cbad"]
输出：1
解释：1 组 ["abcd","cdab","adcb","cbad"]
 */
public class _893_Groups_of_Special_Equivalent_Strings_特殊等价字符串组 {
    class Solution {
        public int numSpecialEquivGroups(String[] A) {
            Set<String> set = new HashSet<>();
            for (String s : A) {
                int[] odd = new int[26];
                int[] even = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    if (i % 2 == 1)
                        odd[s.charAt(i) - 'a']++;
                    else
                        even[s.charAt(i) - 'a']++;
                }
                String sig = Arrays.toString(odd) + Arrays.toString(even);
                set.add(sig);
            }
            return set.size();
        }
    }
}

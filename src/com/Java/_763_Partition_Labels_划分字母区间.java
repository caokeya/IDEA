package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
示例 1:
输入: S = "ababcbacadefegdehijhklij"
输出: [9,7,8]
解释:
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class _763_Partition_Labels_划分字母区间 {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            if (S == null || S.length() == 0) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            int[] map = new int[26]; // record the last index of the each char

            for (int i = 0; i < S.length(); i++) {
                map[S.charAt(i) - 'a'] = i;
            }
            // record the end index of the current sub string
            int last = 0;
            int start = 0;
            for (int i = 0; i < S.length(); i++) {
                last = Math.max(last, map[S.charAt(i) - 'a']);
                if (last == i) {
                    list.add(last - start + 1);
                    start = last + 1;
                }
            }
            return list;
        }
    }
}

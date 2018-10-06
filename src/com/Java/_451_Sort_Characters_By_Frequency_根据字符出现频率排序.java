package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
示例 1:
输入:
"tree"
输出:
"eert"
解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
public class _451_Sort_Characters_By_Frequency_根据字符出现频率排序 {
    public class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);

            List<Character>[] bucket = new List[s.length() + 1];
            for (char key : map.keySet()) {
                int frequency = map.get(key);
                if (bucket[frequency] == null)
                    bucket[frequency] = new ArrayList<>();
                bucket[frequency].add(key);
            }

            StringBuilder sb = new StringBuilder();
            for (int pos = bucket.length - 1; pos >= 0; pos--)
                if (bucket[pos] != null)
                    for (char c : bucket[pos])
                        for (int i = 0; i < map.get(c); i++)
                            sb.append(c);

            return sb.toString();
        }
    }

}

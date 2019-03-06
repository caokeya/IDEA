package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
我们有N种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
您希望通过从您的贴纸集合中剪下单个字母并重新排列它们来拼出给定的目标字符串。
如果你愿意，你可以多次使用每个贴纸，而且每个贴纸的数量是无限的。
你需要拼出目标的最少贴纸数量是多少?如果任务不可能完成，返回-1。
Example 1:
Input:
["with", "example", "science"], "thehat"
Output:
3
Explanation:
我们可以使用2 "with"贴纸，和1 "example"贴纸。
在对这些贴纸的字母进行裁剪和重新排列后，我们可以形成目标“thehat”。
此外，这是形成目标字符串所需的最少贴纸数量。
Example 2:
Input:
["notice", "possible"], "basicbasic"
Output:
-1
Explanation:
我们不能从给定的贴纸上剪下字母来形成目标“基本”。
 */
public class _691_Stickers_to_Spell_Word_拼字贴纸_难 {
    class Solution {
        public int minStickers(String[] stickers, String target) {
            int m = stickers.length;
            int[][] mp = new int[m][26];
            Map<String, Integer> dp = new HashMap<>();
            for (int i = 0; i < m; i++)
                for (char c : stickers[i].toCharArray())
                    mp[i][c - 'a']++;
            dp.put("", 0);
            return helper(dp, mp, target);
        }

        private int helper(Map<String, Integer> dp, int[][] mp, String target) {
            if (dp.containsKey(target))
                return dp.get(target);
            int ans = Integer.MAX_VALUE, n = mp.length;
            int[] tar = new int[26];
            for (char c : target.toCharArray())
                tar[c - 'a']++;
            // try every sticker
            for (int i = 0; i < n; i++) {
                // optimization
                if (mp[i][target.charAt(0) - 'a'] == 0)
                    continue;
                StringBuilder sb = new StringBuilder();
                // apply a sticker on every character a-z
                for (int j = 0; j < 26; j++) {
                    if (tar[j] > 0)
                        for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++)
                            sb.append((char) ('a' + j));
                }
                String s = sb.toString();
                int tmp = helper(dp, mp, s);
                if (tmp != -1)
                    ans = Math.min(ans, 1 + tmp);
            }
            dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
            return dp.get(target);
        }
    }
}

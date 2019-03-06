package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
最终结果按照字典顺序输出。
示例 1:
输入: "abbxxxxzzy"
输出: [[3,6]]
解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
示例 2:
输入: "abc"
输出: []
解释: "a","b" 和 "c" 均不是符合要求的较大分组。
示例 3:
输入: "abcdddeeeeaabbbcd"
输出: [[3,5],[6,9],[12,14]]
 */
public class _830_Positions_of_Large_Groups_较大分组的位置 {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (S == null || S.length() < 3)
                return res;

            int p = 0;
            int count = 1;

            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(i) != S.charAt(p)) {
                    List<Integer> temp = new ArrayList<>();
                    if (count >= 3) {
                        temp.add(p);
                        temp.add(i - 1);
                        res.add(temp);
                    }

                    count = 1;
                    p = i;
                }

                else {
                    count++;
                }
            }

            if (S.length() - p >= 3) {
                List<Integer> temp = new ArrayList<>();
                temp.add(p);
                temp.add(S.length() - 1);
                res.add(temp);
            }

            return res;
        }
    }

    class Solution2 {
        public List<List<Integer>> largeGroupPositions(String S) {
            int i = 0, j = 0, N = S.length();
            List<List<Integer>> res = new ArrayList<>();
            while (j < N) {
                while (j < N && S.charAt(j) == S.charAt(i))
                    ++j;
                if (j - i >= 3)
                    res.add(Arrays.asList(i, j - 1));
                i = j;
            }
            return res;
        }
    }
}

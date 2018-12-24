package src.com.Java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
示例:
输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class _187_Repeated_DNA_Sequences_重复的DNA序列 {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> res = new HashSet<>();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < s.length() - 9; i++) {
                String str = s.substring(i, i + 10);
                if (!set.add(str)) {
                    res.add(str);
                }
            }
            return new ArrayList<String>(res);
        }
    }
}

package src.com.Java;

/*
定义由 n 个连接的字符串 s 组成字符串 S，即 S = [s,n]。例如，["abc", 3]=“abcabcabc”。
另一方面，如果我们可以从 s2 中删除某些字符使其变为 s1，我们称字符串 s1 可以从字符串 s2 获得。
例如，“abc” 可以根据我们的定义从 “abdbec” 获得，但不能从 “acbbe” 获得。
现在给出两个非空字符串 S1 和 S2（每个最多 100 个字符长）和两个整数 0 ≤ N1 ≤ 106 和 1 ≤ N2 ≤ 106。
现在考虑字符串 S1 和 S2，其中S1=[s1,n1]和S2=[s2,n2]。找出可以使[S2,M]从 S1 获得的最大整数 M。
示例：
输入：
s1 ="acb",n1 = 4
s2 ="ab",n2 = 2
返回：
2
 */
public class _466_Count_The_Repetitions_统计重复个数_难 {
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            if (n1 == 0)
                return 0;
            int[] indexr = new int[s2.length() + 1];// index of s2 at start of each s1 block
            int[] countr = new int[s2.length() + 1];// count of repetitions till the present s1 block
            int index = 0;
            int repeat_count = 0;
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < s1.length(); j++) { // 这对循环可以迭代S1的所有字符，但因为有pattern的出现，
                                                        // 因此有可能中途中断，因而加速。
                    // 找repeat
                    if (s1.charAt(j) == s2.charAt(index))
                        index++; // 只有相同是s2的index才会自增
                    if (index == s2.length()) { // 如果到s2的头了，那么归零，并且count自增
                        index = 0;
                        repeat_count++;
                    }
                }
                indexr[i] = index;
                countr[i] = repeat_count;
                for (int k = 0; k < i; k++) {
                    if (indexr[k] == index) {
                        int pre_count = countr[k];
                        int pattern_count = (countr[i] - countr[k]) * ((n1 - 1 - k) / (i - k));
                        int remain_count = countr[k + (n1 - 1 - k) % (i - k)] - countr[k];
                        return (pre_count + pattern_count + remain_count) / n2;
                    }
                }
            }
            return countr[n1 - 1] / n2;
        }
    }

    public class Solution2 {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();
            int count1 = 0, count2 = 0, i = 0, j = 0;

            while (count1 < n1) {
                if (array1[i] == array2[j]) {
                    j++;
                    if (j == array2.length) {
                        j = 0;
                        count2++;
                    }
                }
                i++;
                if (i == array1.length) {
                    i = 0;
                    count1++;
                }
            }
            return count2 / n2;
        }
    }
}

package com.Java;

/*
有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
返回将所有这些移位都应用到 S 后最终得到的字符串。
示例：
输入：S = "abc", shifts = [3,5,9]
输出："rpl"
解释： 
我们以 "abc" 开始。
将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
 */
public class _848_Shifting_Letters_字母移位 {
    class Solution {
        public String shiftingLetters(String S, int[] shifts) {
            for (int i = shifts.length - 1; i >= 0; i--) {
                if (i == shifts.length - 1)
                    continue;
                shifts[i] += shifts[i + 1];
                shifts[i] %= 26;
            }
            char[] tmp = S.toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                int charIndex = (tmp[i] - 'a' + shifts[i]) % 26;
                tmp[i] = (char) (charIndex + 'a');
            }
            return new String(tmp);
        }
    }

    class Solution2 {
        public String shiftingLetters(String S, int[] shifts) {
            char[] arr = S.toCharArray();
            int sum = 0;
            for (int i = shifts.length - 1; i >= 0; i--) {
                int cur = arr[i] - 'a';
                sum += shifts[i] % 26;
                cur += sum;
                arr[i] = (char) ('a' + cur % 26);
            }

            return new String(arr);
        }
    }
}

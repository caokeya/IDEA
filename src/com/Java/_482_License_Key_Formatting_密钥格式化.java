package src.com.Java;

/*
给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，
除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
示例 1：
输入：S = "5F3Z-2e-9-w", K = 4
输出："5F3Z-2E9W"
解释：字符串 S 被分成了两个部分，每部分 4 个字符；
     注意，两个额外的破折号需要删掉。
示例 2：
输入：S = "2-5g-3-J", K = 2
输出："2-5G-3J"
解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 */
public class _482_License_Key_Formatting_密钥格式化 {
    class Solution {
        public String licenseKeyFormatting(String S, int K) {
            int charsAppended = 0;
            StringBuilder result = new StringBuilder();

            for (int i = S.length() - 1; i >= 0; i--) {
                char ch = S.charAt(i);
                if (ch != '-') {
                    if (charsAppended > 0 && charsAppended % K == 0) {
                        result.append('-');
                    }

                    result.append(Character.toUpperCase(ch));
                    charsAppended++;
                }
            }

            return result.reverse().toString();
        }
    }
}

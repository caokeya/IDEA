package src.src.com.Java;

/*
将非负整数转换为其对应的英文表示。可以保证给定输入小于 2^31 - 1 。
示例 1:
输入: 123
输出: "One Hundred Twenty Three"
示例 2:
输入: 12345
输出: "Twelve Thousand Three Hundred Forty Five"
示例 3:
输入: 1234567
输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
示例 4:
输入: 1234567891
输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class _273_Integer_to_English_Words_整数转换英文表示_难 {
    class Solution {
        private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        private final String[] THOUSAND = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            String word = "";
            int i = 0;
            while (num > 0) {
                if (num % 1000 != 0) {
                    word = helper(num % 1000) + THOUSAND[i] + " " + word;
                }
                num /= 1000;
                i++;
            }
            return word.trim();
        }

        private String helper(int num) {
            if (num == 0) {
                return "";
            } else if (num < 20) {
                return LESS_THAN_20[num] + " ";
            } else if (num < 100) {
                return TENS[num / 10] + " " + helper(num % 10);
            } else {
                return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
            }
        }
    }
}

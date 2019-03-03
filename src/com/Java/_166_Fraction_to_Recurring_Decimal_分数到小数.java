package com.Java;

import java.util.HashMap;
import java.util.Map;

/*
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
如果小数部分为循环小数，则将循环的部分括在括号内。
 */
public class _166_Fraction_to_Recurring_Decimal_分数到小数 {
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder sb = new StringBuilder();
            // Reminder, Indexx
            Map<Long, Integer> map = new HashMap<>();
            String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);
            sb.append(sign);
            sb.append(num / den);
            long reminder = num % den;
            if (reminder == 0) {
                return sb.toString();
            }
            sb.append(".");
            while (!map.containsKey(reminder)) {
                map.put(reminder, sb.length());
                sb.append(10 * reminder / den);
                reminder = 10 * reminder % den;
                if (reminder == 0)
                    return sb.toString();
            }
            sb.insert(map.get(reminder), "(");
            sb.append(")");
            return sb.toString();
        }
    }
}

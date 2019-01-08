package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
每个 LED 代表一个 0 或 1，最低位在右侧。
给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
案例:
输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
public class _401_Binary_Watch_二进制手表 {
    class Solution {
        public List<String> readBinaryWatch(int num) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                        ans.add(String.format("%d:%02d", i, j));
                    }
                }
            }
            return ans;
        }
    }

    class Solution2 {
        /*
         * LED灯所在位置和数值的映射关系 包含时 和 分
         */
        private final int[] TIME_BIT_VALUES = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

        public List<String> readBinaryWatch(int num) {
            //10个灯，占用了哪些灯，还有哪些可以被占用，从高位到低位
            List<String> result = new ArrayList<>();
            backTrack(result, new int[10], num, 0, 0);
            return result;
        }

        /*
         * @param result       结果集
         * @param bits         1的位置数组
         * @param targetCount  1的目标个数
         * @param currentCount 当前1的个数
         * @param start        开始位置
         */
        private void backTrack(List<String> result, int[] bits, int targetCount, int currentCount, int start) {
            if (currentCount == targetCount) {
                String time = generateTime(bits);
                if (!"".equals(time)) {
                    result.add(time);
                }
            }

            for (int i = start; i < bits.length; i++) {
                if (bits[i] == 0 && currentCount + 1 <= targetCount) {
                    bits[i] = 1;
                    //高位走到低位
                    backTrack(result, bits, targetCount, currentCount + 1, i + 1);
                    bits[i] = 0;
                }
            }
        }

        /*
         * 计算出时间
         * @param bits
         * @return
         */
        private String generateTime(int[] bits) {
            //计算出小时
            int hour = 0;
            for (int i = 0; i < 4; i++) {
                hour += bits[i] * TIME_BIT_VALUES[i];
            }
            if (hour > 11) {
                return "";
            }
            //计算出分钟
            int min = 0;
            for (int i = 4; i < 10; i++) {
                min += bits[i] * TIME_BIT_VALUES[i];
            }
            if (min > 59) {
                return "";
            }
            return connactTimeString(min, hour);

        }

        /*
         * 拼接小时和分钟字符串
         * @param min
         * @param hour
         * @return
         */
        private String connactTimeString(int min, int hour) {
            StringBuilder timeBuilder = new StringBuilder();
            timeBuilder.append(hour);
            timeBuilder.append(":");
            if (min < 10) {
                timeBuilder.append(0);
            }

            timeBuilder.append(min);
            return timeBuilder.toString();
        }
    }
}

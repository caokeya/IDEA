package src.com.Java;

/*
给定一个字符串来代表一个学生的出勤纪录，这个纪录仅包含以下三个字符：
    'A' : Absent，缺勤
    'L' : Late，迟到
    'P' : Present，到场
如果一个学生的出勤纪录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
你需要根据这个学生的出勤纪录判断他是否会被奖赏。
示例 1:
输入: "PPALLP"
输出: True
示例 2:
输入: "PPALLL"
输出: False
 */
public class _551_Student_Attendance_Record_学生出勤纪录 {
    class Solution {
        public boolean checkRecord(String s) {
            if (s == null || s.length() < 2) {
                return true;
            }

            int countA = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'A') {
                    countA++;
                    if (countA == 2) {
                        return false;
                    }
                }

                if (s.charAt(i) == 'L') {
                    if (i > 1 && s.charAt(i - 2) == s.charAt(i - 1) && s.charAt(i - 1) == 'L') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
自除数 是指可以被它包含的每一位数除尽的数。
例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
还有，自除数不允许包含 0 。
给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
示例 1：
输入： 
上边界left = 1, 下边界right = 22
输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class _728_Self_Dividing_Numbers_自除数 {
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {

            ArrayList<Integer> res = new ArrayList<Integer>();

            for (int i = left; i <= right; i++) {
                for (int j = i; j > 0; j /= 10) {

                    if (j % 10 == 0 || i % (j % 10) != 0)
                        break;

                    if (j / 10 == 0)
                        res.add(i);
                }

            }

            return res;
        }
    }
}

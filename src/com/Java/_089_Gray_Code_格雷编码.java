package src.com.Java;

import java.util.LinkedList;
import java.util.List;

public class _089_Gray_Code_格雷编码 {
    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < 1 << n; i++)
                result.add(i ^ i >> 1);
            return result;
        }
    }
}

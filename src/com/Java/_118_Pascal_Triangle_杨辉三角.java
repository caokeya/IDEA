package com.Java;

import java.util.ArrayList;
import java.util.List;
/*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class _118_Pascal_Triangle_杨辉三角 {
    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> row, pre = null;
            for (int i = 0; i < numRows; ++i) {
                row = new ArrayList<Integer>();
                for (int j = 0; j <= i; ++j)
                    if (j == 0 || j == i)
                        row.add(1);
                    else
                        row.add(pre.get(j - 1) + pre.get(j));
                pre = row;
                res.add(row);
            }
            return res;
        }
    }

}

package com.Java;

import java.util.ArrayList;
import java.util.List;
/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
示例:
输入: 3
输出: [1,3,3,1]
 */
public class _119_Pascal_Triangle_ll_杨辉三角2 {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<Integer>();
            if (rowIndex < 0)
                return list;

            for (int i = 0; i < rowIndex + 1; i++) {
                list.add(0, 1);
                for (int j = 1; j < list.size() - 1; j++) {
                    list.set(j, list.get(j) + list.get(j + 1));
                }
            }
            return list;
        }
    }
}

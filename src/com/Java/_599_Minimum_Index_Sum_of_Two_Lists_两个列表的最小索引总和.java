package com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
示例 1:
输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。
示例 2:
输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 */
public class _599_Minimum_Index_Sum_of_Two_Lists_两个列表的最小索引总和 {
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> res = new ArrayList<String>();
            Map<String, Integer> map1 = new HashMap<String, Integer>();
            for (int i = 0; i < list1.length; i++)
                map1.put(list1[i], i);
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < list2.length; i++) {
                String name = list2[i];
                if (map1.containsKey(name)) {
                    int sum = map1.get(name) + i;
                    if (sum < minIndex) {
                        res.clear();
                        minIndex = sum;
                        res.add(name);
                    } else if (sum == minIndex) {
                        res.add(name);
                    }
                }
            }
            String[] ans = new String[res.size()];
            for (int i = 0; i < res.size(); i++)
                ans[i] = res.get(i);
            return ans;
        }
    }
}

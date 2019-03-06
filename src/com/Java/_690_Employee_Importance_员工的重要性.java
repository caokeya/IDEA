package src.com.Java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。
注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
示例 1:
输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
输出: 11
解释:
员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
注意:
    一个员工最多有一个直系领导，但是可以有多个直系下属
    员工数量不超过2000。
您是否在真实的面试环节中遇到过这道题目呢？  
    题目难度：简单
    通过次数：1.2K
    提交次数：2.8K
    贡献者：LeetCode

相关话题 

 */
public class _690_Employee_Importance_员工的重要性 {
    /*
     * // Employee info
     */
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    class Solution {
        public int getImportance(List<Employee> employees, int id) {

            HashMap<Integer, Employee> map = new HashMap<>();

            for (Employee e : employees)
                map.put(e.id, e);

            Employee e = map.get(id);

            return getImp(map, e);
        }

        private int getImp(HashMap<Integer, Employee> map, Employee e) {
            int imp = 0;

            imp += e.importance;

            for (int i : e.subordinates)
                imp += getImp(map, map.get(i));

            return imp;
        }

    }

    class Solution2 {
        public int getImportance(List<Employee> employees, int id) {
            if (employees == null || employees.size() == 0)
                return 0;
            int sum = 0;
            Queue<Employee> queue = new LinkedList<Employee>();
            Map<Integer, Employee> map = new HashMap<Integer, Employee>();

            for (Employee e : employees) {
                map.put(e.id, e);
                if (e.id == id) {
                    queue.offer(e);
                }
            }

            while (!queue.isEmpty()) {
                Employee leader = queue.poll();
                sum = sum + leader.importance;
                List<Integer> sub = leader.subordinates;
                for (Integer s : sub) {
                    queue.offer(map.get(s));
                }
            }

            return sum;
        }

    }
}

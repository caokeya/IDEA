package src.com.Mysql;
/*
编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
 */
public class _176_Second_Highest_Salary_第二高的薪水 {
    /*
    SELECT distinct
        IFNULL(
          (SELECT DISTINCT Salary  //DISTINCT返回唯一值
           FROM Employee
           ORDER BY Salary DESC    //DESC降序
            LIMIT 1 OFFSET 1),     //LIMIT 1 OFFSET 1 从第二条开始读取，读取第2条
        NULL) AS SecondHighestSalary
    ;
     */
    
}

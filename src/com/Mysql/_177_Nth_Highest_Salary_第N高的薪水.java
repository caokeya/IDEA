package src.com.Mysql;
/*
编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
 */
public class _177_Nth_Highest_Salary_第N高的薪水 {
    /*
        CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
        BEGIN
        DECLARE M INT;
        SET M=N-1;
          RETURN (
              SELECT DISTINCT Salary
              FROM Employee
              ORDER BY Salary DESC
              LIMIT M, 1
          );
        END
     */
}

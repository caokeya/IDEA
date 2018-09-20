package src.com.Mysql;
/*
Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
Department 表包含公司所有部门的信息。
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
 */
public class _184_Department_Highest_Salary_部门工资最高的员工 {
    /*
        SELECT D.Name AS Department ,E.Name AS Employee ,E.Salary 
        FROM
            Employee E,
            (SELECT DepartmentId,max(Salary) as max FROM Employee GROUP BY DepartmentId) T,
            Department D
        WHERE E.DepartmentId = T.DepartmentId 
          AND E.Salary = T.max
          AND E.DepartmentId = D.id
     */
}

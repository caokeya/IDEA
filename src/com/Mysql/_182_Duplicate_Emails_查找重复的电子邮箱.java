package src.com.Mysql;
/*
编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
示例：
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
根据以上输入，你的查询应返回以下结果：
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
 */
public class _182_Duplicate_Emails_查找重复的电子邮箱 {
    /*
        select email
        from person
        group by email
        having count(email) > 1
     */
}

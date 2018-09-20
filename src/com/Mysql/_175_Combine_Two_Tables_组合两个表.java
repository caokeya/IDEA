package src.com.Mysql;
/*
表1: Person
+-------------+---------+
| 列名         | 类型     |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId 是上表主键

表2: Address
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId 是上表主键
 */
public class _175_Combine_Two_Tables_组合两个表 {
    /*
      SELECT Person.FirstName, Person.LastName, Address.City, Address.State 
      from Person 
      LEFT JOIN Address 
      on Person.PersonId = Address.PersonId;
     */
}
    

package src.com.Mysql;
/*
给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+
例如，根据上述给定的 Weather 表格，返回如下 Id:
+----+
| Id |
+----+
|  2 |
|  4 |
+----+
 */
public class _197_Rising_Temperature_上升的温度 {
    /*
        SELECT t1.Id
        FROM Weather t1
        INNER JOIN Weather t2
        ON TO_DAYS(t1.RecordDate) = TO_DAYS(t2.RecordDate) + 1    //TO_DAYS函数 返回一个天数,从年份0开始的天数 
        WHERE t1.Temperature > t2.Temperature
     */
}

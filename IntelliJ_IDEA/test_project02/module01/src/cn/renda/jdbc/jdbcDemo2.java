package cn.renda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Renda Zhang
 * @create 2020-04-20 21:48
 */
public class jdbcDemo2 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/renda?characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement statement = conn.createStatement();

        int count = 0;
        count += statement.executeUpdate("insert into student values(null, '孙悟空', 1, '1993-03-24')");
        count += statement.executeUpdate("insert into student values(null, '白骨精', 0, '1995-03-24')");
        count += statement.executeUpdate("insert into student values(null, '猪八戒', 1, '1903-03-24')");
        count += statement.executeUpdate("insert into student values(null, '嫦娥', 0, '1993-03-11')");
        System.out.println("Count of Query inserted: " + count);

        statement.close();
        conn.close();
    }
}

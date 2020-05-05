package cn.renda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Renda Zhang
 * @create 2020-04-20 21:21
 */
public class jdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/renda?characterEncoding=utf8";
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, "root", "root");
            statement = conn.createStatement();
            statement.executeUpdate("create table student (id int PRIMARY key auto_increment, " +
                    "name VARCHAR(20) not null, gender boolean, birthday date)");
            System.out.println("Table student has been created successfully. ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

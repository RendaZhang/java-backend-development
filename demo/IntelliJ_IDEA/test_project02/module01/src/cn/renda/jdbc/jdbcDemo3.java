package cn.renda.jdbc;

import cn.renda.utils.jdbcUtils;

import java.sql.*;

/**
 * @author Renda Zhang
 * @create 2020-04-20 21:56
 */
public class jdbcDemo3 {
    public static void main(String[] args) throws SQLException {
        Connection conn = jdbcUtils.getConnection();
        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM student");

        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            boolean gender = rs.getBoolean("gender");
            Date birthday = rs.getDate("birthday");
            System.out.println("id: " + id + ", name: " + name
                    + ", gender: " + gender + ", birthday: " + birthday);
        }

        jdbcUtils.close(conn,statement, rs);
    }
}

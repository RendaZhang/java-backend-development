package cn.renda.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Renda Zhang
 * @create 2020-04-20 22:24
 */
public class jdbcUtils {

    private static final String USER = "root";
    private static final String PWD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/renda?characterEncoding=utf8";
    private static final String DRIVER= "com.mysql.jdbc.Driver";

    private static DataSource ds;

    static {
        Properties pro = new Properties();
        try {
            pro.load(jdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void  close(Connection conn, Statement stmt) {
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn, stmt);
    }

    public static DataSource getDataSource() {
        return ds;
    }

}

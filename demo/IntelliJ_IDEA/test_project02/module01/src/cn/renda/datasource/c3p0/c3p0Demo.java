package cn.renda.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Renda Zhang
 * @create 2020-04-21 0:10
 */
public class c3p0Demo {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}

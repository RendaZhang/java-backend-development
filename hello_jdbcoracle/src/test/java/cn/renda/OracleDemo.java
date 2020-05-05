package cn.renda;

import oracle.jdbc.driver.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import org.junit.Test;

import java.sql.*;

/**
 * @author Renda Zhang
 * @create 2020-05-02 23:32
 */
public class OracleDemo {

    @Test
    public void javaCallOracle() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "renda", "renda");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from emp where empno=?");
        preparedStatement.setObject(1, 7788);
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("ename"));
        }

        rs.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void javaCallProcedure() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "renda", "renda");

        CallableStatement callableStatement = connection.prepareCall("{call p_yearsal(?, ?)}");
        callableStatement.setObject(1, "7788");
        callableStatement.registerOutParameter(2, OracleTypes.NUMBER);
        callableStatement.execute();
        System.out.println(callableStatement.getObject(2));

        callableStatement.close();
        connection.close();
    }

    @Test
    public void javaCallFunction() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "renda", "renda");

        CallableStatement callableStatement = connection.prepareCall("{? = call f_yearsal(?)}");
        callableStatement.setObject(2, "7654");
        callableStatement.registerOutParameter(1, OracleTypes.NUMBER);
        callableStatement.execute();
        System.out.println(callableStatement.getObject(1));

        callableStatement.close();
        connection.close();
    }
}

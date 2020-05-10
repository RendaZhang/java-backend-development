package cn.renda.datasource.druid;

import cn.renda.utils.jdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Renda Zhang
 * @create 2020-04-21 0:42
 */
public class SpringDemo {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(jdbcUtils.getDataSource());

        String sql = "update employee set age = 30 where id = ?";
        int count = template.update(sql, 1);
        System.out.println(count);
    }
}

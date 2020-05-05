package cn.renda.test;

import cn.renda.dao.AccountDao;
import cn.renda.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @author Renda Zhang
 * @create 2020-05-02 1:05
 */
public class MyBatisTest {
    /**
     * Test findAll
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = factory.openSession();
        AccountDao dao = session.getMapper(AccountDao.class);

        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

        session.close();
        resourceAsStream.close();
    }

    /**
     * Test saveAccount
     * @throws IOException
     */
    @Test
    public void run2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = factory.openSession();
        AccountDao dao = session.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("熊大");
        account.setMoney(400d);

        dao.saveAccount(account);

        session.commit();
        session.close();
        resourceAsStream.close();
    }
}

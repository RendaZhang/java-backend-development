package cn.renda.mybatis;

import cn.renda.dao.IUserDao;
import cn.renda.domain.QueryVo;
import cn.renda.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-04-28 22:50
 */
public class MybatisTest {
    private static IUserDao userDao;
    private static SqlSession session;
    private static InputStream in;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        List<User>  users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() throws IOException {
        User user = new User();
        user.setUsername("NewUser");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.saveUser(user);

        System.out.println(user);
    }

    @Test
    public void testUpdateUser() throws IOException {
        User user = new User();
        user.setUsername("UpdatedUser");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setId(49);

        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser() throws IOException {
        userDao.deleteUser(49);
    }


    @Test
    public void testFindUserById() throws IOException {
        User user = userDao.findUserById(48);
        System.out.println(user);
    }


    @Test
    public void testFindByName() throws IOException {
        List<User> users = userDao.findByName("%王%");
        for (User user:users) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindTotal() throws IOException {
        int count = userDao.findTotal();
        System.out.println(count);
    }


    @Test
    public void testFindByVo() throws IOException {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);

        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

}

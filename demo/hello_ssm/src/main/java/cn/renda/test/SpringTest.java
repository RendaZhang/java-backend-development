package cn.renda.test;

import cn.renda.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Renda Zhang
 * @create 2020-05-02 0:14
 */
public class SpringTest {

    @Test
    public void run1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();

    }
}

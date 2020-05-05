package cn.renda.service.impl;

import cn.renda.dao.IAccountDao;
import cn.renda.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
@Scope("singleton") // default:Singleton
public class AccountServiceImpl implements IAccountService {
//    @Autowired
    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    @PostConstruct
    public void init() {
        System.out.println("AccountServiceImpl 初始化方法执行了");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AccountServiceImpl 的销毁方法执行了");
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public AccountServiceImpl(){
        System.out.println("AccoutServiceImpl对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}

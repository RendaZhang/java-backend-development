package cn.renda.dao.impl;

import cn.renda.dao.IAccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    public  void saveAccount(){
        System.out.println("accountDaoImpl对象执行了saveAccount");
    }
}

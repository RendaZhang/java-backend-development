package cn.renda.service.impl;

import cn.renda.dao.AccountDao;
import cn.renda.domain.Account;
import cn.renda.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-02 0:04
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户");
        accountDao.saveAccount(account);
    }
}

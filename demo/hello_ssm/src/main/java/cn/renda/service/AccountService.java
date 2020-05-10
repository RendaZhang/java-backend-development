package cn.renda.service;

import cn.renda.domain.Account;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-02 0:04
 */
public interface AccountService {
    //查询所有账户信息
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);
}

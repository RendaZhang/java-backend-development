package cn.renda.service;

import cn.renda.dao.IAccountDao;

/**
 * 账户业务层的接口
 */
public interface IAccountService {
    IAccountDao getAccountDao();

    /**
     * 模拟保存账户
     */
    void saveAccount();
}

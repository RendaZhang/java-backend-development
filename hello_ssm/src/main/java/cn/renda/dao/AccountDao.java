package cn.renda.dao;

import cn.renda.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-02 0:02
 */
public interface AccountDao {
    //查询所有账户信息
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息
    @Insert("insert into account (name, money) values (#{name},#{money})")
    public void saveAccount(Account account);
}

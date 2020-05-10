package cn.renda.dao;

import cn.renda.domain.QueryVo;
import cn.renda.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-04-28 22:16
 */
public interface IUserDao {
    /**
     * 查询所有的操作
     * @return 一个User类型的list
     */
//    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     *  根据id查询用户信息
     * @param userId
     * @return 一个用户
     */
    User findUserById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return 一个User类型的List
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return int类型的总数
     */
    int findTotal();

    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return 一个用户
     */
    List<User> findUserByVo(QueryVo vo);
}

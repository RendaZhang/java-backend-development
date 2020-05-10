package cn.renda.user.service;

import cn.renda.user.mapper.UserMapper;
import cn.renda.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-04 17:30
 */
@Service
public class UserService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
        return this.userMapper.selectByPrimaryKey(id);
    }

    public List<User> queryAll() {
        return this.userMapper.selectAll();
    }

    @Transactional
    public void insert(User user) {
        this.userMapper.insert(user);
    }

    @Transactional
    public void deleteById(Long id){
        this.userMapper.deleteByPrimaryKey(id);
    }
}

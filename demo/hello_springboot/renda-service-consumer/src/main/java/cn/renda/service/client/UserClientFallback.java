package cn.renda.service.client;

import cn.renda.service.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author Renda Zhang
 * @create 2020-05-06 13:48
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setUsername("服务器繁忙，请稍后再试！");
        return user;
    }
}

package com.xxx.auth.service;

import com.xxx.auth.client.UserClient;
import com.xxx.auth.config.JwtProperties;
import com.xxx.auth.entity.UserInfo;
import com.xxx.auth.utils.JwtUtils;
import com.xxx.user.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Renda Zhang
 * @create 2020-05-14 16:12
 */
@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserClient userClient;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JwtProperties properties;

    public String authentication(String username, String password) {

        try {
            // logger.info("用户信息：" + username + password);
            // 调用微服务，执行查询
            User user = this.userClient.queryUser(username, password);

            // 如果查询结果为null，则直接返回null
            if (user == null) {
                return null;
            }

            // 如果有查询结果，则生成token
            String token = JwtUtils.generateToken(new UserInfo(user.getId(), user.getUsername()),
                    properties.getPrivateKey(), properties.getExpire());
            // logger.info("获取token: " + token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

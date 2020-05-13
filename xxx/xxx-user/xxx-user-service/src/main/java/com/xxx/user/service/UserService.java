package com.xxx.user.service;

import com.xxx.common.utils.CodecUtils;
import com.xxx.common.utils.NumberUtils;
import com.xxx.user.mapper.UserMapper;
import com.xxx.user.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Renda Zhang
 * @create 2020-05-13 14:18
 */
@Service
public class UserService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String KEY_PREFIX = "user:code:phone:";

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public Boolean sendVerifyCode(String phone) {
        // 生成验证码
        String code = NumberUtils.generateCode(6);
        try {
            // 发送短信
            Map<String, String> msg = new HashMap<>();
            msg.put("phone", phone);
            msg.put("code", code);
            this.amqpTemplate.convertAndSend("xxx.sms.exchange", "sms.verify.code", msg);
            // 将code存入redis
            this.redisTemplate.opsForValue().set(KEY_PREFIX + phone, code, 5, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            logger.error("发送短信失败。phone：{}， code：{}", phone, code);
            return false;
        }
    }

    public Boolean checkData(String data, Integer type) {
        User record = new User();
        switch (type) {
            case 1:
                record.setUsername(data);
                break;
            case 2:
                record.setPhone(data);
                break;
            default:
                return null;
        }
        return this.userMapper.selectCount(record) == 0; // 查看数量是否为0，如果为0则可用
    }

    public Boolean register(User user, String code) {
        // 校验短信验证码
        String cacheCode = this.redisTemplate.opsForValue().get(KEY_PREFIX + user.getPhone());
        if (!StringUtils.equals(code, cacheCode)) {
            return false;
        }

        // 初始化用户信息
        String salt = CodecUtils.generateSalt(); // 生成盐
        user.setSalt(salt);
        user.setPassword(CodecUtils.md5Hex(user.getPassword(), salt)); // 对密码加密
        user.setId(null); // 强制设置不能指定的参数为null
        user.setCreated(new Date());

        // 添加到数据库
        boolean b = this.userMapper.insertSelective(user) == 1;
        if(b){
            this.redisTemplate.delete(KEY_PREFIX + user.getPhone()); // 注册成功，删除redis中的记录
        }
        return b;
    }
}
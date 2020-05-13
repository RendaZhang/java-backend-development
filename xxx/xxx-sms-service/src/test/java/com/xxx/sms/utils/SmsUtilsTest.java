package com.xxx.sms.utils;

import com.aliyuncs.exceptions.ClientException;
import com.xxx.sms.config.SmsProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Renda Zhang
 * @create 2020-05-13 19:14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SmsUtilsTest {
    @Autowired
    private SmsUtils smsUtils;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SmsProperties prop;

    @Test
    public void sendSms() {
        try {
            // 测试短信验证码的发送
            this.smsUtils.sendSms("13925067232", "32567", prop.getSignName(), prop.getVerifyCodeTemplate());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
package com.xxx.auth;

import com.xxx.auth.entity.UserInfo;
import com.xxx.auth.utils.JwtUtils;
import com.xxx.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author Renda Zhang
 * @create 2020-05-14 15:19
 */
public class JwtTest {

    private static final String pubKeyPath = "D:\\tmp\\rsa\\rsa.pub";
    private static final String priKeyPath = "D:\\tmp\\rsa\\rsa.pri";
    private PublicKey publicKey;
    private PrivateKey privateKey;

    /**
     * 测试生成公钥和私钥，
     * 注意运行这段代码需要先把 @Before 方法注释掉
     * @throws Exception
     */
    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    /**
     * 测试生成token
     * @throws Exception
     */
    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    /**
     * 测试解析token
     * @throws Exception
     */
    @Test
    public void testParseToken() throws Exception {
        // 由 testGenerateToken 方法生成
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU4OTQ0MTQ0MX0.bAOWUUuUwhet14EuBjGGw2VOeiFjo9WN6wTTezKYpT9KfVzW-Rv8XvT3o6XHyxDgoj2bMB9rnyiUZJuQgyrdS0XMRjJhJ-rVG1Wt8qHvwGLPvY8S73nkdU1JFph9qEjcrnAyddx_d1QG_Nc_mgD0ubF4NMUVMdIY1XdeCVyZG7w";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}

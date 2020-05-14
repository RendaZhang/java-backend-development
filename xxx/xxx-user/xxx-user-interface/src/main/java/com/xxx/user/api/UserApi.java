package com.xxx.user.api;

import com.xxx.user.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Renda Zhang
 * @create 2020-05-14 16:08
 */
public interface UserApi {

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public User queryUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password);

}

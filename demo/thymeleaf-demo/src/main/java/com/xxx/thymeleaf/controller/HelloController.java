package com.xxx.thymeleaf.controller;

import com.xxx.thymeleaf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-11 18:34
 */
@Controller
public class HelloController {

    @GetMapping("show1")
    public String show1(Model model){
        model.addAttribute("msg", "Hello, Thymeleaf!");
        return "hello";
    }

    @GetMapping("show2")
    public String show2(Model model){
        User user = new User();
        user.setAge(21);
        user.setSex(true);
        user.setName("Renda Zhang");
        user.setRole("admin");
        user.setFriend(new User("张人大", 24));

        User user2 = new User();
        user2.setSex(false);
        user2.setAge(33);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("user"+i,21+i, null, true));
        }

        model.addAttribute("user", user);
        model.addAttribute("user2", user2);
        model.addAttribute("users", users);
        return "hello2";
    }

    @GetMapping("show3")
    public String show3(Model model){
        model.addAttribute("today", new Date());
        return "hello3";
    }
}

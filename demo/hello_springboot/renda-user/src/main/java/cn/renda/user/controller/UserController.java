package cn.renda.user.controller;

import cn.renda.user.pojo.User;
import cn.renda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-04 16:34
 */
// @RestController = @Controller + @ResponseBody
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public String all(Model model) {
        // 查询用户
        List<User> users = this.userService.queryAll();
        // 放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }

    @GetMapping("{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id")Long id){
        return this.userService.queryById(id);
    }

    @GetMapping("hello")
    @ResponseBody
    public String test(){
        return "hello ssm";
    }
}

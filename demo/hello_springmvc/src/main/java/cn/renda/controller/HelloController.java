package cn.renda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Renda Zhang
 * @create 2020-05-01 13:54
 */
@Controller
@RequestMapping(path="/user")
public class HelloController {

    @RequestMapping(path="/hello",  method={RequestMethod.GET})
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return "success";
    }

    @RequestMapping(value="/testRequestMapping",params = {"username"})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping ... ");
        return "success";
    }
}

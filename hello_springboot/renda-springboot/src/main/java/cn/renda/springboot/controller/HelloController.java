package cn.renda.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author Renda Zhang
 * @create 2020-05-04 14:18
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("show")
    public String test(){
        return "hello Spring Boot! 2";
    }

}

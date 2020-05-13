package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Renda Zhang
 * @create 2020-05-13 13:22
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xxx.user.mapper")
public class XxxUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxxUserApplication.class, args);
    }
}

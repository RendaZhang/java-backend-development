package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Renda Zhang
 * @create 2020-05-07 1:12
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xxx.item.mapper")
public class XxxItemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxxItemServiceApplication.class, args);
    }
}
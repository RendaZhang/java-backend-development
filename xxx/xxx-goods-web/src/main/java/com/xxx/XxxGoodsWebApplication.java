package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Renda Zhang
 * @create 2020-05-11 19:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class XxxGoodsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxxGoodsWebApplication.class, args);
    }
}

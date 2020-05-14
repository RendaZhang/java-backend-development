package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Renda Zhang
 * @create 2020-05-14 14:41
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class XxxAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxxAuthApplication.class, args);
    }
}

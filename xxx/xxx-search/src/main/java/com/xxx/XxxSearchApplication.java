package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Renda Zhang
 * @create 2020-05-10 22:39
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class XxxSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxxSearchApplication.class, args);
    }
}

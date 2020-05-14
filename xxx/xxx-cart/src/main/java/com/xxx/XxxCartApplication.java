package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.swing.*;

/**
 * @author Renda Zhang
 * @create 2020-05-14 22:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class XxxCartApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxxCartApplication.class, args);
    }
}

package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Renda Zhang
 * @create 2020-05-07 1:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XxxItemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxxItemServiceApplication.class, args);
    }
}
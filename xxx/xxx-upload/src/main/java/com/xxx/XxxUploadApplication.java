package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Renda Zhang
 * @create 2020-05-08 16:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XxxUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxxUploadApplication.class, args);
    }
}
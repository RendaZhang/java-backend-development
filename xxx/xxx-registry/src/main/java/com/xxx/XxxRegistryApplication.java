package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Renda Zhang
 * @create 2020-05-07 0:13
 */
@SpringBootApplication
@EnableEurekaServer
public class XxxRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxxRegistryApplication.class, args);
    }
}
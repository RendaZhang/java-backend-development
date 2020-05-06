package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Renda Zhang
 * @create 2020-05-07 0:46
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class XxxGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxxGatewayApplication.class, args);
    }
}
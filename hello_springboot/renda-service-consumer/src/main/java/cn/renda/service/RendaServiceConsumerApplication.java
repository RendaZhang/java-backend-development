package cn.renda.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient // 开启Eureka客户端
//@EnableCircuitBreaker // 开启Hystrix熔断
@SpringCloudApplication // = @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker
public class RendaServiceConsumerApplication {

	@Bean
    @LoadBalanced //启动Ribbon负载均衡
    public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RendaServiceConsumerApplication.class, args);
	}

}

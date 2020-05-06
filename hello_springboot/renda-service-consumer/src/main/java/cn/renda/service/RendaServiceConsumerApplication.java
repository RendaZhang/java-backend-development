package cn.renda.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient // 开启Eureka客户端
//@EnableCircuitBreaker // 开启Hystrix熔断
@SpringCloudApplication // = @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker
@EnableFeignClients
public class RendaServiceConsumerApplication {

    // 删除RestTemplate**：feign已经自动集成了Ribbon负载均衡的RestTemplate。所以，此处不需要再注册RestTemplate。
/*	@Bean
    @LoadBalanced //启动Ribbon负载均衡
    public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(RendaServiceConsumerApplication.class, args);
	}

}

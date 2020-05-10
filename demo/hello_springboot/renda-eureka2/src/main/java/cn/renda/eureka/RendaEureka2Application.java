package cn.renda.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RendaEureka2Application {

	public static void main(String[] args) {
		SpringApplication.run(RendaEureka2Application.class, args);
	}

}

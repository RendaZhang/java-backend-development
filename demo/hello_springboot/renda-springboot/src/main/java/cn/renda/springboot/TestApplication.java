package cn.renda.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 引导类，springboot的入口
 * @author Renda Zhang
 * @create 2020-05-04 14:38
 */
@SpringBootApplication // = @EnableAutoConfiguration + @ComponentScan + @SpringBootConfiguration
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}

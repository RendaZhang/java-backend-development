package cn.renda.service.controller;

import cn.renda.service.client.UserClient;
import cn.renda.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-05 14:08
 */
@Controller
@RequestMapping("consumer")
// @DefaultProperties(defaultFallback = "fallBackMethod") // 指定一个类的全局熔断方法
public class UserController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserClient userClient;

    // 删除RestTemplate**：feign已经自动集成了Ribbon负载均衡的RestTemplate。所以，此处不需要再注册RestTemplate。
/*    @Autowired
    private RestTemplate restTemplate;*/

/*    @Autowired
    private DiscoveryClient discoveryClient; // eureka客户端，可以获取到eureka中服务的信息*/

    @GetMapping
    @ResponseBody
    // @HystrixCommand(fallbackMethod = "queryUserByIdFallBack")
//    @HystrixCommand // 标记该方法需要熔断
    public User queryUserById(@RequestParam("id") Long id){
/*        // Get Server Instance(s) from Eureka Server
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        // Get the first instance
        ServiceInstance instance = instances.get(0);
        // Acquire the ip address and port number, concatenate as the server address.
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;*/

        // 触发熔断机制
/*        if(id == 3){
            throw new RuntimeException("Server is busy now");
        }*/

        // Use Ribbon Load-balanced function to acquire service
        //return this.restTemplate.getForObject("http://service-provider/user/" + id, String.class);
        User user = this.userClient.queryById(id);
        return user;
    }

/*    *//**
     * 熔断方法
     * @param id 和被熔断的方法参数列表一致
     * @return 返回值要和被熔断的方法的返回值一致
     *//*
    public String queryUserByIdFallBack(Long id){
        return "Server is Busy, Please Try again Later. 服务器繁忙，请稍后再试！";
    }

    *//**
     * 类的默认熔断方法
     * 熔断方法不需要参数
     * @return 返回值要和被熔断的方法的返回值一致
     *//*
    public String fallBackMethod(){
        return "类的默认熔断：请求繁忙，请稍后再试！";
    }*/

}

package cn.renda.service.controller;

import cn.renda.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-05 14:08
 */
@Controller
@RequestMapping("consumer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; // eureka客户端，可以获取到eureka中服务的信息


    @GetMapping
    @ResponseBody
    public User queryUserById(@RequestParam("id") Long id){
        // Get Server Instance(s) from Eureka Server
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        // Get the first instance
        ServiceInstance instance = instances.get(0);
        // Acquire the ip address and port number, concatenate as the server address.
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        return user;
    }

}

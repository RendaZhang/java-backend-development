package cn.renda.service.client;

import cn.renda.service.configuration.FeignLogConfiguration;
import cn.renda.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Renda Zhang
 * @create 2020-05-06 13:20
 */
@FeignClient(value = "service-provider",
        fallback = UserClientFallback.class ,
        configuration = FeignLogConfiguration.class)
public interface UserClient {

    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}

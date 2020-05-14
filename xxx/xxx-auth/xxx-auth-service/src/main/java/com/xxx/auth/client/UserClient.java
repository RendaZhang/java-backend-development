package com.xxx.auth.client;

import com.xxx.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Renda Zhang
 * @create 2020-05-14 16:18
 */
@FeignClient(value = "user-service")
public interface UserClient extends UserApi {
}

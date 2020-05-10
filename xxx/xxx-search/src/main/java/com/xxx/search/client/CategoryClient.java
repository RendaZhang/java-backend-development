package com.xxx.search.client;

import com.xxx.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Renda Zhang
 * @create 2020-05-10 23:23
 */
@FeignClient(value = "item-service")
public interface CategoryClient extends CategoryApi {
}

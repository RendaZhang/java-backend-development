package com.xxx.goods.client;

import com.xxx.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Renda Zhang
 * @create 2020-05-10 23:23
 */
@FeignClient("item-service")
public interface SpecificationClient extends SpecificationApi {
}
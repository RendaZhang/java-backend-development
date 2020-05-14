package com.xxx.cart.client;

import com.xxx.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Renda Zhang
 * @create 2020-05-15 1:35
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}
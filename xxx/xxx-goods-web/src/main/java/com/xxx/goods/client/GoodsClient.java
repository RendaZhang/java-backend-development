package com.xxx.goods.client;

import com.xxx.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Renda Zhang
 * @create 2020-05-10 23:09
 */
@FeignClient(value = "item-service")
public interface GoodsClient extends GoodsApi {
}

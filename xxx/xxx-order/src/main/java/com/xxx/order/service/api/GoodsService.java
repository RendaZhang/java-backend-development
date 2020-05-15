package com.xxx.order.service.api;

import com.xxx.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "xxx-gateway", path = "/api/item")
public interface GoodsService extends GoodsApi {
}

package com.xxx.goods.service;

import com.xxx.goods.client.BrandClient;
import com.xxx.goods.client.CategoryClient;
import com.xxx.goods.client.GoodsClient;
import com.xxx.goods.client.SpecificationClient;
import com.xxx.item.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Renda Zhang
 * @create 2020-05-11 22:41
 */
@Service
public class GoodsService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BrandClient brandClient;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryClient categoryClient;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private GoodsClient goodsClient;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SpecificationClient specificationClient;

    public Map<String, Object> loadData(Long spuId){
        // 根据id查询spu对象
        Spu spu = this.goodsClient.querySpuById(spuId);

        // 查询spudetail
        SpuDetail spuDetail = this.goodsClient.querySpuDetailBySpuId(spuId);

        // 查询sku集合
        List<Sku> skus = this.goodsClient.querySkusBySpuId(spuId);

        // 查询分类
        List<Long> cids = Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3());
        List<String> names = this.categoryClient.queryNamesByIds(cids);
        List<Map<String, Object>> categories = new ArrayList<>();
        for (int i = 0; i < cids.size(); i++) {
            Map<String, Object> categoryMap = new HashMap<>();
            categoryMap.put("id", cids.get(i));
            categoryMap.put("name", names.get(i));
            categories.add(categoryMap);
        }

        // 查询品牌
        Brand brand = this.brandClient.queryBrandById(spu.getBrandId());

        // 查询规格参数组
        List<SpecGroup> groups = this.specificationClient.queryGroupsWithParamsByCid(spu.getCid3());

        // 查询特殊的规格参数 (非generic的即是特殊的)
        List<SpecParam> params = this.specificationClient.queryParams(null, spu.getCid3(), false, null);
        Map<Long, String> paramMap = new HashMap<>();
        params.forEach(param -> {
            paramMap.put(param.getId(), param.getName());
        });

        Map<String, Object> map = new HashMap<>();
        map.put("spu", spu); // 封装spu
        map.put("spuDetail", spuDetail); // 封装spuDetail
        map.put("skus", skus); // 封装sku集合
        map.put("categories", categories); // 分类
        map.put("brand", brand); // 品牌
        map.put("groups", groups); // 规格参数组
        map.put("paramMap", paramMap); // 查询特殊规格参数
        return map;
    }
}

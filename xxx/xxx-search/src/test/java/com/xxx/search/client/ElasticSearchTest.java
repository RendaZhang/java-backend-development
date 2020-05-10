package com.xxx.search.client;

import com.xxx.XxxSearchApplication;
import com.xxx.common.pojo.PageResult;
import com.xxx.item.bo.SpuBo;
import com.xxx.item.pojo.Spu;
import com.xxx.search.pojo.Goods;
import com.xxx.search.repository.GoodsRepository;
import com.xxx.search.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Renda Zhang
 * @create 2020-05-10 23:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = XxxSearchApplication.class)
public class ElasticSearchTest {

    @Autowired
    private GoodsRepository goodsReponsitory;

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private SearchService searchService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private GoodsClient goodsClient;

    @Test
    public void createIndex(){
        // 创建索引库，以及映射
        this.template.createIndex(Goods.class);
        this.template.putMapping(Goods.class);
    }

    @Test
    public void searchServiceBuildGoods(){
        // 创建索引
        this.template.createIndex(Goods.class);
        // 配置映射
        this.template.putMapping(Goods.class);
        Integer page = 1;
        Integer rows = 100;

        do {
            // 分批查询spuBo
            PageResult<SpuBo> pageResult = this.goodsClient.querySpuBoByPage(null, true, page, rows);
            // 遍历spubo集合转化为List<Goods>
            List<Goods> goodsList = pageResult.getItems().stream().map(spuBo -> {
                try {
                    return this.searchService.buildGoods((Spu) spuBo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }).collect(Collectors.toList());
            this.goodsReponsitory.saveAll(goodsList);

            // 获取当前页的数据条数，如果是最后一页，没有100条
            rows = pageResult.getItems().size();
            // 每次循环页码加1
            page++;
        } while (rows == 100);
    }
}

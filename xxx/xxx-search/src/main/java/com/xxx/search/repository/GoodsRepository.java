package com.xxx.search.repository;

import com.xxx.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Renda Zhang
 * @create 2020-05-10 23:53
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods, Long> {
}

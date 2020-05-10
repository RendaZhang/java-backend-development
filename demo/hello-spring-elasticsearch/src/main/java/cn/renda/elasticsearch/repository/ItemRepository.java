package cn.renda.elasticsearch.repository;

import cn.renda.elasticsearch.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-10 19:37
 */
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    /**
     * 根据价格区间查询
     * @param price1
     * @param price2
     * @return
     */
    List<Item> findByPriceBetween(double price1, double price2);
}
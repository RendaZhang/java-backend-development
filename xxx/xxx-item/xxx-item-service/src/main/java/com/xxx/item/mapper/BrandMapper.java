package com.xxx.item.mapper;

import com.xxx.item.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-08 14:20
 */
public interface BrandMapper extends Mapper<Brand> {
    /**
     * 根据分类（Category）id通过中间表查询品牌
     * @param cid
     * @return
     */
    @Select("SELECT b.* from tb_brand b INNER JOIN tb_category_brand cb on b.id=cb.brand_id where cb.category_id=#{cid}")
    List<Brand> selectBrandByCid(Long cid);

    /**
     * 新增商品分类和品牌中间表数据
     * @param cid 商品分类id
     * @param bid 品牌id
     * @return
     */
    @Insert("INSERT INTO tb_category_brand(category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertBrandAndCategory(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 根据brand_id删除商品分类和品牌中间表数据
     * @param bid
     * @return
     */
    @Delete("DELETE FROM tb_category_brand WHERE brand_id = #{bid}")
    int deleteBrandAndCategoryByBrandId(@Param("bid") Long bid);
}

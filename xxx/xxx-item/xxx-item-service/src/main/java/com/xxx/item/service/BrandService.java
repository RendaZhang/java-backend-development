package com.xxx.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.common.pojo.PageResult;
import com.xxx.item.mapper.BrandMapper;
import com.xxx.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-08 14:31
 */
@Service
public class BrandService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 根据查询条件分页并排序查询品牌信息
     *
     * @param key
     * @param pageNum
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    public PageResult<Brand> queryBrandsByPage(String key, Integer pageNum, Integer rows, String sortBy, Boolean desc) {

        // 初始化example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        // 根据name模糊查询，或者根据首字母查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        // 添加分页条件
        if (rows<0) {
            PageHelper.startPage(pageNum, 0);
            PageHelper.getLocalPage().setPageSizeZero(true);
        } else {
            PageHelper.startPage(pageNum, rows);
        }

        
        // 添加排序条件
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }

        List<Brand> brands = this.brandMapper.selectByExample(example);
        // 包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {

        // 先新增brand
        this.brandMapper.insertSelective(brand);

        // 再新增中间表
        // 业务逻辑中维护两张表，避免在数据库中使用ForeignKey，以增加运行效率
        cids.forEach(cid -> {
            this.brandMapper.insertBrandAndCategory(cid, brand.getId());
        });
    }

    /**
     * 更新品牌
     * @param brand
     * @param cids
     */
    @Transactional
    public void updateBrand(Brand brand, List<Long> cids) {
        // 先更新brand
        this.brandMapper.updateByPrimaryKeySelective(brand);

        // 再更新中间表：先删除再插入
        this.brandMapper.deleteBrandAndCategoryByBrandId(brand.getId());
        cids.forEach(cid -> {
            this.brandMapper.insertBrandAndCategory(cid, brand.getId());
        });
    }

    /**
     * 删除品牌
     * @param id
     */
    @Transactional
    public void deleteBrand(Long id) {
        // 先删除brand
        this.brandMapper.deleteByPrimaryKey(id);

        // 再删除中间表
        this.brandMapper.deleteBrandAndCategoryByBrandId(id);
    }
}

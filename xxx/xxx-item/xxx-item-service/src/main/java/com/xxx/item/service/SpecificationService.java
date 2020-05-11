package com.xxx.item.service;

import com.xxx.item.mapper.SpecGroupMapper;
import com.xxx.item.mapper.SpecParamMapper;
import com.xxx.item.pojo.SpecGroup;
import com.xxx.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-09 16:39
 */
@Service
public class SpecificationService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SpecGroupMapper groupMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SpecParamMapper paramMapper;


    /**
     * 根据cid查询规格参数组，及组内参数
     * @param cid
     * @return
     */
    public List<SpecGroup> queryGroupsWithParamsByCid(Long cid) {
        // 查询规格组
        List<SpecGroup> groups = this.queryGroupsByCid(cid);
        groups.forEach(g -> {
            // 查询组内参数
            g.setParams(this.queryParams(g.getId(), null, null, null));
        });
        return groups;
    }

    /**
     * 根据cid查询规格参数组
     * @param cid
     * @return
     */
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return this.groupMapper.select(specGroup);
    }

    /**
     * 新增规格分组
     * @param specGroup
     */
    @Transactional
    public void saveSpecGroup(SpecGroup specGroup) {
        this.groupMapper.insertSelective(specGroup);
    }

    /**
     * 删除规格分组
     * @param id
     */
    @Transactional
    public void deleteSpecGroup(Long id) {
        this.groupMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新规格分组
     * @param specGroup
     */
    @Transactional
    public void updateSpecGroup(SpecGroup specGroup) {
        this.groupMapper.updateByPrimaryKeySelective(specGroup);
    }

    /**
     * 根据GroupId或CategoryId或者generic或者searching查询规格参数
     * @param gid
     * @param cid
     * @param generic
     * @param searching
     * @return
     */
    public List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);
        return this.paramMapper.select(record);
    }

    /**
     * 根据GroupId查询规格参数
     * @param gid
     * @return
     */
    public List<SpecParam> queryParamsByGroupId(Long gid) {
        SpecParam param = new SpecParam();
        param.setGroupId(gid);
        return this.paramMapper.select(param);
    }

    /**
     * 新增规格参数
     * @param specParam
     */
    @Transactional
    public void saveParam(SpecParam specParam) {
        this.paramMapper.insertSelective(specParam);
    }

    /**
     * 删除规格参数
     * @param id
     */
    @Transactional
    public void deleteParam(Long id) {
        this.paramMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新规格参数
     * @param specParam
     */
    @Transactional
    public void updateParam(SpecParam specParam) {
        this.paramMapper.updateByPrimaryKeySelective(specParam);
    }
}

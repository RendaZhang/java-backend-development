package com.xxx.item.api;

import com.xxx.item.pojo.SpecGroup;
import com.xxx.item.pojo.SpecParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-10 23:16
 */
@RequestMapping("spec")
public interface SpecificationApi {

    /**
     * 根据cid查询规格参数组，及组内参数
     * @param cid
     * @return
     */
    @GetMapping("groups/params/{cid}")
    public List<SpecGroup> queryGroupsWithParamsByCid(@PathVariable("cid") Long cid);

    /**
     * 根据分类id查询规格参数组
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public List<SpecGroup> queryGroupsByCid(@PathVariable("cid") Long cid);

    /**
     * 根据GroupId或CategoryId或者generic或者searching查询规格参数
     * @param gid
     * @param cid
     * @param generic
     * @param searching
     * @return
     */
    @GetMapping("params")
    public List<SpecParam> queryParams(
            @RequestParam(value = "gid", required = false)Long gid,
            @RequestParam(value = "cid", required = false)Long cid,
            @RequestParam(value = "generic", required = false)Boolean generic,
            @RequestParam(value = "searching", required = false)Boolean searching
    );

}

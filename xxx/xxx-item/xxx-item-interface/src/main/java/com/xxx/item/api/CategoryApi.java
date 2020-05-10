package com.xxx.item.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-10 23:15
 */
@RequestMapping("category")
public interface CategoryApi {
    /**
     * 根据id 查询分类
     * @param ids 一个List
     * @return ResponseEntity<List<String>>
     */
    @GetMapping("names")
    List<String> queryNamesByIds(@RequestParam("ids")List<Long> ids);
}
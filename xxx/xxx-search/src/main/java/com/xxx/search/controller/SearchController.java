package com.xxx.search.controller;

import com.xxx.common.pojo.PageResult;
import com.xxx.search.pojo.Goods;
import com.xxx.search.pojo.SearchRequest;
import com.xxx.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Renda Zhang
 * @create 2020-05-11 11:27
 */
@RestController
@RequestMapping
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * 搜索商品
     *
     * @param request 一个Json格式的对象
     * @return
     */
    @PostMapping("page")
    public ResponseEntity<PageResult<Goods>> search(@RequestBody SearchRequest request) {
        PageResult<Goods> result = this.searchService.search(request);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
}

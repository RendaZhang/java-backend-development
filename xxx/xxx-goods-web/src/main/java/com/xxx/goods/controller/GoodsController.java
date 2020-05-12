package com.xxx.goods.controller;

import com.xxx.goods.service.GoodsHtmlService;
import com.xxx.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Renda Zhang
 * @create 2020-05-11 20:35
 */
@Controller
@RequestMapping("item")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsHtmlService goodsHtmlService;

    /**
     * 跳转到商品详情页
     * @param model
     * @param id
     * @return
     */
    @GetMapping("{id}.html")
    public String toItemPage(Model model, @PathVariable("id")Long id){
        // 加载所需的数据
        Map<String, Object> modelMap = this.goodsService.loadData(id);
        // 把数据放入数据模型
        model.addAllAttributes(modelMap);

        // 页面静态化
        // 生成html 的代码不能对用户请求产生影响，这里使用额外的线程进行异步创建
        this.goodsHtmlService.asyncExcute(id);
        return "item";
    }
}
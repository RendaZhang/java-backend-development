package com.xxx.item.bo;

import com.xxx.item.pojo.Sku;
import com.xxx.item.pojo.Spu;
import com.xxx.item.pojo.SpuDetail;

import java.util.List;

/**
 * @author Renda Zhang
 * @create 2020-05-09 20:19
 */
public class SpuBo extends Spu {
    private String cname;// 商品分类名称
    private String bname;// 品牌名称
    private SpuDetail spuDetail;// 商品详情
    private List<Sku> skus;// sku列表

    public SpuDetail getSpuDetail() {
        return spuDetail;
    }

    public void setSpuDetail(SpuDetail spuDetail) {
        this.spuDetail = spuDetail;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

// 略 。。
}

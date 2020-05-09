package com.xxx.item.bo;

import com.xxx.item.pojo.Spu;

/**
 * @author Renda Zhang
 * @create 2020-05-09 20:19
 */
public class SpuBo extends Spu {

    String cname;// 商品分类名称

    String bname;// 品牌名称

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

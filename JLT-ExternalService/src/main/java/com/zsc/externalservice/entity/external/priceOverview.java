package com.zsc.externalservice.entity.external;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class priceOverview {
    private String product_name;
    // 零售价格
    private double retail_price;
    // 用户零售价格
    private double recognized_price;
    // 直销零售价格
    private double direct_retail_price;
    // 行业公司
    private String industry_company;
    // 价格类型代码
    private String price_type_code;
    // 产品类型代码
    private String product_type_code;
    // 产品代码
    private String product_code;
}

package com.zsc.externalservice.entity.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetails {
    private double direct_retail_price;   // 直销零售价格
    private double whole_sale_price;       // 批发价格
    private String is_province;            // 是否为省份
    private String product_type_code;      // 产品类型代码
    private String price_type_code_text;   // 价格类型代码文本
    private double gross_margin;           // 毛利率
    private String is_sale;                // 是否销售
    private String is_delivery;            // 是否配送
    private String brand_uuid;             // 品牌UUID
    private double tar_qty;                // 焦油量
    private double nicotine_qty;           // 尼古丁含量
    private double co_qty;                 // 一氧化碳含量
    private String spec;                   // 规格
}

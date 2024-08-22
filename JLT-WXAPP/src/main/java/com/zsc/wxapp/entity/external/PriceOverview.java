package com.zsc.wxapp.entity.external;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PriceOverview {
    private String productName;
    // 零售价格
    private double retailPrice;
    // 用户零售价格
    private double recognizedPrice;
    // 直销零售价格
    private double directRetailPrice;
    // 厂家简称
    private String factorySimpleName;
    // 价格类型代码
    private String priceTypeCode;
    // 产品类型代码
    private String productTypeCode;
    // 产品代码
    private String productCode;
}

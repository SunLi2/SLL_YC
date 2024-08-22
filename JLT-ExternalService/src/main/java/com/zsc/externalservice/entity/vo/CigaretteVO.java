package com.zsc.externalservice.entity.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CigaretteVO {
    //卷烟名称
    private String productName;
    //卷烟照片
    private String url;
    //建议零售价
    private BigDecimal directRetailPrice;
    //批发价
    private BigDecimal wholeSalePrice;
    //毛利率
    private String grossProfitMargin;
    //产地
    private String placeOfOrigin;
    //入网时间
    private String entryTime;
    //类型
    private String priceType;
    //是否在售
    private String isOnSale;
    //厂家名称
    private String factoryName;
    //焦油含量
    private BigDecimal tarQty;
    //烟气烟碱含量
    private BigDecimal nicotineQty;
    //一氧化碳含量
    private BigDecimal coQty;
    //包装规格
    private String productStyle;
    //每条多少包
    private String packageQty;
    //每盒多少包
    private String packageQty2;
    //卖点介绍
    private String sellingPoints;
    //产品代码
    private String productCode;
}

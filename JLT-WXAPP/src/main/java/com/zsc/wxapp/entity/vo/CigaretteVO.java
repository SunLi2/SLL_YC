package com.zsc.wxapp.entity.vo;


import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "卷烟名称")
    private String productName;

    @ApiModelProperty(value = "卷烟照片")
    private String url;

    @ApiModelProperty(value = "建议零售价")
    private BigDecimal directRetailPrice;

    @ApiModelProperty(value = "批发价")
    private BigDecimal wholeSalePrice;

    @ApiModelProperty(value = "毛利率")
    private String grossProfitMargin;

    @ApiModelProperty(value = "产地")
    private String placeOfOrigin;

    @ApiModelProperty(value = "入网时间")
    private String entryTime;

    @ApiModelProperty(value = "类型")
    private String priceType;

    @ApiModelProperty(value = "是否在售")
    private String isOnSale;

    @ApiModelProperty(value = "厂家名称")
    private String factoryName;

    @ApiModelProperty(value = "焦油含量")
    private BigDecimal tarQty;

    @ApiModelProperty(value = "烟气烟碱含量")
    private BigDecimal nicotineQty;

    @ApiModelProperty(value = "一氧化碳含量")
    private BigDecimal coQty;

    @ApiModelProperty(value = "包装规格")
    private String productStyle;

    @ApiModelProperty(value = "每包多少条")
    private Integer packageQty;

    @ApiModelProperty(value = "每条多少条")
    private Integer packageQty2;

    @ApiModelProperty(value = "卖点介绍")
    private String sellingPoints;

    @ApiModelProperty(value = "产品代码")
    private String productCode;
}

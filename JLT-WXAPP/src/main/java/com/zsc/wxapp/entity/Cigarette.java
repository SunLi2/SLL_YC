package com.zsc.wxapp.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cigarette {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "卷烟名称")
    private String productName;

    @ApiModelProperty(value = "卷烟照片")
    private String url;

    @ApiModelProperty(value = "零售指导价")
    private Double directRetailPrice;

    @ApiModelProperty(value = "批发价")
    private Double wholeSalePrice;

    @ApiModelProperty(value = "毛利率")
    private String grossProfitMargin;

    @ApiModelProperty(value = "产地")
    private String placeOfOrigin;

    @ApiModelProperty(value = "卷烟创建时间")
    private String entryTime;

    @ApiModelProperty(value = "价格类型")
    private String priceType;

    @ApiModelProperty(value = "是否销售")
    private String isOnSale;

    @ApiModelProperty(value = "工厂简称（所属公司）")
    private String factoryName;

    @ApiModelProperty(value = "焦油含量")
    private BigDecimal tarQty;

    @ApiModelProperty(value = "烟气烟碱含量")
    private BigDecimal nicotineQty;

    @ApiModelProperty(value = "一氧化碳含量")
    private BigDecimal coQty;

    @ApiModelProperty(value = "包装规格")
    private String productStyle;

    @ApiModelProperty(value = "包包装支数")
    private Integer packageQty;

    @ApiModelProperty(value = "条包装支数")
    private Integer packageQty2;

    @ApiModelProperty(value = "卷烟描述")
    private String sellingPoints;

    @ApiModelProperty(value = "产品代码")
    private String productCode;


}


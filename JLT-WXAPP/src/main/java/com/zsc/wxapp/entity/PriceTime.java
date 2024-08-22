package com.zsc.wxapp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "每日价格表")
public class PriceTime {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "烟名称")
    private String productName;

    @ApiModelProperty(value = "零售价")
    private BigDecimal retailPrice;

    @ApiModelProperty(value = "零售指导价")
    private BigDecimal directRetailPrice;

    @ApiModelProperty(value = "厂家简称")
    private String factorySimpleName;

    @ApiModelProperty(value = "卷烟价类")
    private String priceTypeCode;

    @ApiModelProperty(value = "卷烟类型")
    private String productTypeCode;

    @ApiModelProperty(value = "产品代码")
    private String productCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDate createTime;
}

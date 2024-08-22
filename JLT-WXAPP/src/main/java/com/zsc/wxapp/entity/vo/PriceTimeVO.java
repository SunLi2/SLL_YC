package com.zsc.wxapp.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "返回每日价格情况数据")
@Data
public class PriceTimeVO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "卷烟名称")
    private String product_name;

    @ApiModelProperty(value = "市场零售价")
    private BigDecimal retail_price;

    @ApiModelProperty(value = "涨幅")
    private BigDecimal recognized_price;

    @ApiModelProperty(value = "建议零售价")
    private BigDecimal direct_retail_price;

    @ApiModelProperty(value = "参考毛利率")
    private BigDecimal refer_gross_profit_margin;

    @ApiModelProperty(value = "产品代码")
    private String product_code;

    @ApiModelProperty(value = "时间")
    private LocalDate date;
}

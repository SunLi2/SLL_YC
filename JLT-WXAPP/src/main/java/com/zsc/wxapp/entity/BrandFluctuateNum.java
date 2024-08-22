package com.zsc.wxapp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "品牌浮动数量表")
public class BrandFluctuateNum {

    @ApiModelProperty(value = "上涨品牌数量")
    private Integer upNum;

    @ApiModelProperty(value = "平价品牌数量")
    private Integer parityNum;

    @ApiModelProperty(value = "下跌品牌数量")
    private Integer downNum;
}

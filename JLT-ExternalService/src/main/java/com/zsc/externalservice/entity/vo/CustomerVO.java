package com.zsc.externalservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {

    @ApiModelProperty(value = "客户标识")
    private String custUuid;

    @ApiModelProperty(value = "许可证号")
    private String licenseCode;

    @ApiModelProperty(value = "客户编码")
    private String custCode;

    @ApiModelProperty(value = "企业名称")
    private String custName;

    @ApiModelProperty(value = "经营地址")
    private String address;

    @ApiModelProperty(value = "雪茄烟档位")
    private  String cigarGrade;

    @ApiModelProperty(value = "许可证有效期止")
    private String licenseEndDate;
}

package com.zsc.externalservice.entity.external;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PriceNameData {
    private LocalDate productUploadDate;
    // 产品名称
//    private String product_name;
    // 直销零售价格
    private Double actualRetailPrice;
}

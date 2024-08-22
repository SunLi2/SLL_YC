package com.zsc.wxapp.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PricePageDTO {

    private Integer pageNum;

    private Integer pageSize;

    private String product_name;

    private String factory_simple_name;

    //TODO 继续完成这个查询条件,数据库的查询需要更改

    private LocalDate date;
}

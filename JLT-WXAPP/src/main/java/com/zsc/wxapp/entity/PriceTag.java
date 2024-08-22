package com.zsc.wxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceTag {

    private String pt_uuid;
    private String cust_uuid; // 客户标识
    private String pic_urlid; // 上传烟架照片的id
    private String pt_type; // 价签类别
    private String product_uuid; // 卷烟标识
    private String pt_create_date; // 标签创建日期
    private Float recognized_price; // 识别价格
    private String product_name; // 卷烟名称
    private Float direct_retail_price; // 零售指导价
    private String cigarette_total_info_uuid; // 卷烟总信息标识

    private String cust_total_info_uuid; // 客户总信息唯一标识


}
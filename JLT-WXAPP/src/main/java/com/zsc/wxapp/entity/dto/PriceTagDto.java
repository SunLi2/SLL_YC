package com.zsc.wxapp.entity.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceTagDto {

    private String product_name; // 卷烟名称
    private Float recognized_price; // 识别价格
    @JsonProperty("ptUrl")
    private String ptUrl;

    private String cust_uuid; // 客户标识
    private String pt_type; // 价签类别



//    private String pt_uuid;
//
//    private String pic_urlid; // 上传烟架照片的id
//
//    private String product_uuid; // 卷烟标识
//    private String pt_create_date; // 标签创建日期
//
//
//    private Float direct_retail_price; // 零售指导价
//    private String cigarette_total_info_uuid; // 卷烟总信息标识
//    private String cust_total_info_uuid; // 客户总信息唯一标识
}

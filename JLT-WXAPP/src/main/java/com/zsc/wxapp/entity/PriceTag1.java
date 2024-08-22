package com.zsc.wxapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PriceTag1 {

    @JsonProperty("pturl_uuid")
    private String pturlUuid;

    @JsonProperty("cust_uuid")
    private String custUuid;

    @JsonProperty("pt_id")
    private String ptId;

    @JsonProperty("pt_type")
    private String ptType;

    @JsonProperty("product_uuid")
    private String productUuid;

    @JsonProperty("pt_create_date")
    private Date ptCreateDate;

    @JsonProperty("recognized_price")
    private Float recognizedPrice;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("direct_retail_price")
    private Float directRetailPrice;

    @JsonProperty("cigarette_total_info_uuid")
    private String cigaretteTotalInfoUuid;

    @JsonProperty("cust_total_info_uuid")
    private String custTotalInfoUuid;
}

package com.zsc.externalservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class PriceTag {
//    private String pturlUuid;
//    private String custUuid;
//    private String ptUrl;
//    private String ptType;
//    private String productUuid;
//    private Date ptCreateDate;
//    private Float recognizedPrice;
//    private String productName;
//    private Float directRetailPrice;

    @JsonProperty("pturlUuid")
    private String pturlUuid;

    @JsonProperty("custUuid")
    private String custUuid;

    @JsonProperty("ptUrl")
    private String ptUrl;

    @JsonProperty("ptType")
    private String ptType;

    @JsonProperty("productUuid")
    private String productUuid;

    @JsonProperty("ptCreateDate")
    private Date ptCreateDate;

    @JsonProperty("recognizedPrice")
    private Float recognizedPrice;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("directRetailPrice")
    private Float directRetailPrice;

    public String getPturlUuid() {
        return pturlUuid;
    }

    public void setPturlUuid(String pturlUuid) {
        this.pturlUuid = pturlUuid;
    }

    public String getCustUuid() {
        return custUuid;
    }

    public void setCustUuid(String custUuid) {
        this.custUuid = custUuid;
    }

    public String getPtUrl() {
        return ptUrl;
    }

    public void setPtUrl(String ptUrl) {
        this.ptUrl = ptUrl;
    }

    public String getPtType() {
        return ptType;
    }

    public void setPtType(String ptType) {
        this.ptType = ptType;
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public Date getPtCreateDate() {
        return ptCreateDate;
    }

    public void setPtCreateDate(Date ptCreateDate) {
        this.ptCreateDate = ptCreateDate;
    }

    public Float getRecognizedPrice() {
        return recognizedPrice;
    }

    public void setRecognizedPrice(Float recognizedPrice) {
        this.recognizedPrice = recognizedPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getDirectRetailPrice() {
        return directRetailPrice;
    }

    public void setDirectRetailPrice(Float directRetailPrice) {
        this.directRetailPrice = directRetailPrice;
    }
}

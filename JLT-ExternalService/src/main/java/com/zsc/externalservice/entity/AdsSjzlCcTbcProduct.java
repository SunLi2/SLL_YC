package com.zsc.externalservice.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "新营销卷烟商品表")
public class AdsSjzlCcTbcProduct {

    @ApiModelProperty(value = "卷烟标识")
    private String productUuid;

    private Long id;

    @ApiModelProperty(value = "管理单元标识")
    private String manageUnitUuid;

    @ApiModelProperty(value = "管理单元名称")
    private String manageUnitName;

    @ApiModelProperty(value = "卷烟编码")
    private String productCode;

    @ApiModelProperty(value = "系统编码")
    private String sysCode;

    @ApiModelProperty(value = "卷烟名称")
    private String productName;

    @ApiModelProperty(value = "国家局卷烟名称")
    private String countryProductName;

    @ApiModelProperty(value = "卷烟照片")
    private String photoFid;

    @ApiModelProperty(value = "厂家标识")
    private String factoryUuid;

    @ApiModelProperty(value = "厂家简称")
    private String factorySimpleName;

    @ApiModelProperty(value = "品牌标识")
    private String brandUuid;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "是否异形包装")
    private String isAbnormity;

    @ApiModelProperty(value = "包装长度(mm)")
    private BigDecimal length;

    @ApiModelProperty(value = "包装宽度(mm)")
    private BigDecimal width;

    @ApiModelProperty(value = "包装高度(mm)")
    private BigDecimal height;

    @ApiModelProperty(value = "制作类型")
    private String productTypeCode;

    @ApiModelProperty(value = "制作类型描述")
    private String productTypeCodeText;

    @ApiModelProperty(value = "包装类型")
    private String productStyleCode;

    @ApiModelProperty(value = "包装类型描述")
    private String productStyleCodeText;

    @ApiModelProperty(value = "焦油含量(mg)")
    private BigDecimal tarQty;

    @ApiModelProperty(value = "焦油含量生效日期")
    private String tarBeginDate;

    @ApiModelProperty(value = "包装主色系")
    private String mainColor;

    @ApiModelProperty(value = "烟嘴颜色")
    private String filterColor;

    @ApiModelProperty(value = "口味")
    private String taste;

    @ApiModelProperty(value = "规格")
    private String spec;

    @ApiModelProperty(value = "缺省单位")
    private String defaultUnitUuid;

    @ApiModelProperty(value = "缺省单位名称")
    private String defaultUnitName;

    @ApiModelProperty(value = "烟气烟碱含量(mg)")
    private BigDecimal nicotineQty;

    @ApiModelProperty(value = "嘴烟类型")
    private String filterCode;

    @ApiModelProperty(value = "嘴烟类型描述")
    private String filterCodeText;

    @ApiModelProperty(value = "销项税率")
    private BigDecimal saleTaxRate;

    @ApiModelProperty(value = "进项税率")
    private BigDecimal buyTaxRate;

    @ApiModelProperty(value = "包图片")
    private String imageFid;

    @ApiModelProperty(value = "包条形码")
    private String barCode;

    @ApiModelProperty(value = "包包装支数")
    private BigDecimal packageQty;

    @ApiModelProperty(value = "包主包装色")
    private String packageMainColor;

    @ApiModelProperty(value = "包副包装色")
    private String packageSubColor;

    @ApiModelProperty(value = "包填写说明")
    private String packageDesc;

    @ApiModelProperty(value = "条图片")
    private String imageFid2;

    @ApiModelProperty(value = "条条形码")
    private String barCode2;

    @ApiModelProperty(value = "条包装支数")
    private BigDecimal packageQty2;

    @ApiModelProperty(value = "条主包装色")
    private String packageMainColor2;

    @ApiModelProperty(value = "条副包装色")
    private String packageSubColor2;

    @ApiModelProperty(value = "条填写说明")
    private String packageDesc2;

    @ApiModelProperty(value = "件图片")
    private String imageFid3;

    @ApiModelProperty(value = "件条形码")
    private String barCode3;

    @ApiModelProperty(value = "件包装支数")
    private BigDecimal packageQty3;

    @ApiModelProperty(value = "件主包装色")
    private String packageMainColor3;

    @ApiModelProperty(value = "件副包装色")
    private String packageSubColor3;

    @ApiModelProperty(value = "件填写说明")
    private String packageDesc3;

    @ApiModelProperty(value = "卷烟价类")
    private String priceTypeCode;

    @ApiModelProperty(value = "卷烟价类描述")
    private String priceTypeCodeText;

    @ApiModelProperty(value = "不含税出厂价")
    private BigDecimal factoryPriceNotax;

    @ApiModelProperty(value = "批发指导价")
    private BigDecimal directWholePrice;

    @ApiModelProperty(value = "零售指导价")
    private BigDecimal directRetailPrice;

    @ApiModelProperty(value = "是否低档烟")
    private String isLower;

    @ApiModelProperty(value = "是否进入价格目录")
    private String isInPriceList;

    @ApiModelProperty(value = "是否常销烟")
    private String isOfften;

    @ApiModelProperty(value = "是否进口烟")
    private String isIntake;

    @ApiModelProperty(value = "是否骨干品牌")
    private String isMainProduct;

    @ApiModelProperty(value = "是否名优烟")
    private String isFamous;

    @ApiModelProperty(value = "是否省内烟")
    private String isProvince;

    @ApiModelProperty(value = "是否查扣烟启用")
    private String isSeized;

    @ApiModelProperty(value = "是否特种烟")
    private String isSpecial;

    @ApiModelProperty(value = "烟支周长")
    private BigDecimal circumference;

    @ApiModelProperty(value = "滤嘴长度(mm)")
    private BigDecimal filterLength;

    @ApiModelProperty(value = "烟支长度(mm)")
    private BigDecimal tbcLength;

    @ApiModelProperty(value = "烟支总长度(mm)")
    private BigDecimal tbcTotalLength;

    @ApiModelProperty(value = "是否细支烟")
    private String isTiny;

    @ApiModelProperty(value = "合并至卷烟")
    private String vestProductUuid;

    @ApiModelProperty(value = "合并至卷烟名称")
    private String vestProductName;

    @ApiModelProperty(value = "是否启用")
    private String isActive;

    @ApiModelProperty(value = "产品信息维护管理单元")
    private String ownerManageUnitUuid;

    @ApiModelProperty(value = "拼音助记码")
    private String shortAlpha;

    @ApiModelProperty(value = "数字助记码")
    private String shortCode;

    @ApiModelProperty(value = "短信简码")
    private String shortMessage;

    @ApiModelProperty(value = "调剂价")
    private BigDecimal adjustPrice;

    @ApiModelProperty(value = "零售价")
    private BigDecimal retailPrice;

    @ApiModelProperty(value = "批发价")
    private BigDecimal wholeSalePrice;

    @ApiModelProperty(value = "购入价")
    private BigDecimal buyPrice;

    @ApiModelProperty(value = "移库价")
    private BigDecimal movePrice;

    @ApiModelProperty(value = "调拨价")
    private BigDecimal allotPrice;

    @ApiModelProperty(value = "是否允许终端订货")
    private String isTerminalOrder;

    @ApiModelProperty(value = "是否地区骨干品牌")
    private String isLocalMain;

    @ApiModelProperty(value = "是否紧俏品牌")
    private String isShort;

    @ApiModelProperty(value = "货源属性")
    private String supplyFully;

    @ApiModelProperty(value = "货源属性描述")
    private String supplyFullyText;

    @ApiModelProperty(value = "引入日期")
    private String inBeginDate;

    @ApiModelProperty(value = "上市日期")
    private String saleBeginDate;

    @ApiModelProperty(value = "退出日期")
    private String outBeginDate;

    @ApiModelProperty(value = "终端使用状态")
    private String terminalStatus;

    @ApiModelProperty(value = "终端使用状态描述")
    private String terminalStatusText;

    @ApiModelProperty(value = "市公司是否启用")
    private String orgIsActive;

    @ApiModelProperty(value = "创建人")
    private String syscreatoruuid;

    @ApiModelProperty(value = "创建时间")
    private String syscreatedate;

    @ApiModelProperty(value = "最后修改人")
    private String sysupdateuseruuid;

    @ApiModelProperty(value = "最后修改时间")
    private String sysupdatetime;

    @ApiModelProperty(value = "是否删除")
    private String sysisdelete;

    @ApiModelProperty(value = "外部标识")
    private String extId;

    @ApiModelProperty(value = "是否历史启用")
    private String hisActive;

    private String orgIsAbnormity;

    @ApiModelProperty(value = "是否爆珠")
    private String isExplodingBeads;

    private String isMedium;

    private String isShortbranch;

    private String bureauPrice;


}


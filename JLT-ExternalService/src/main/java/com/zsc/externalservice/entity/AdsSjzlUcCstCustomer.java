package com.zsc.externalservice.entity;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "新营销零售客户基本信息表")
public class AdsSjzlUcCstCustomer {

    @ApiModelProperty(value = "客户标识")
    private String custUuid;

    @ApiModelProperty(value = "日期")
    private Date pdate;

    @ApiModelProperty(value = "许可证号")
    private String licenseCode;

    @ApiModelProperty(value = "客户编码")
    private String custCode;

    @ApiModelProperty(value = "管理单元标识")
    private String manageUnitUuid;

    @ApiModelProperty(value = "市公司标识")
    private String corpUuid;

    @ApiModelProperty(value = "区县单位标识")
    private String countyUuid;

    @ApiModelProperty(value = "市场部标识")
    private String departUuid;

    @ApiModelProperty(value = "市公司名称")
    private String corpName;

    @ApiModelProperty(value = "区县名称")
    private String countyName;

    @ApiModelProperty(value = "市场部名称")
    private String departName;

    @ApiModelProperty(value = "区县单位系统编码")
    private String countySysCode;

    @ApiModelProperty(value = "系统编码")
    private String sysCode;

    @ApiModelProperty(value = "国家局统一编码")
    private String stateCustCode;

    @ApiModelProperty(value = "助记码")
    private String shortName;

    @ApiModelProperty(value = "经营邮编")
    private String postCode;

    @ApiModelProperty(value = "企业名称")
    private String custName;

    @ApiModelProperty(value = "经营地址")
    private String address;

    @ApiModelProperty(value = "企业经济性质")
    private String economyCode;

    @ApiModelProperty(value = "企业经济性质描述")
    private String economyCodeText;

    @ApiModelProperty(value = "经济性质其它情况")
    private String economyOther;

    @ApiModelProperty(value = "经营业态")
    private String busiPlaceCode;

    @ApiModelProperty(value = "经营业态描述")
    private String busiPlaceCodeText;

    @ApiModelProperty(value = "业态细分")
    private String subBusiCode;

    @ApiModelProperty(value = "业态细分描述")
    private String subBusiCodeText;

    @ApiModelProperty(value = "经营方式")
    private String tradeModeCode;

    @ApiModelProperty(value = "经营方式描述")
    private String tradeModeCodeText;

    @ApiModelProperty(value = "经营范围")
    private String tradeScopeCode;

    @ApiModelProperty(value = "经营范围描述")
    private String tradeScopeCodeText;

    @ApiModelProperty(value = "其它经营范围")
    private String otherTradeScope;

    @ApiModelProperty(value = "其它经营范围描述")
    private String otherTradeScopeText;

    @ApiModelProperty(value = "有无营业执照")
    private String hasBusiLice;

    @ApiModelProperty(value = "工商营业执照号")
    private String busiLiceNo;

    @ApiModelProperty(value = "营业执照有效期类型")
    private String businessValidType;

    @ApiModelProperty(value = "营业执照开始日期")
    private String businessValidStart;

    @ApiModelProperty(value = "工商营业执照有效期")
    private String busiLiceExpr;

    @ApiModelProperty(value = "许可证有效期起")
    private String licenseBeginDate;

    @ApiModelProperty(value = "许可证有效期止")
    private String licenseEndDate;

    @ApiModelProperty(value = "发证机关")
    private String issueOrgName;

    @ApiModelProperty(value = "发证机关编码")
    private String issueOrgCode;

    @ApiModelProperty(value = "制证日期")
    private String makeLiceDate;

    @ApiModelProperty(value = "发证日期")
    private String issueDate;

    @ApiModelProperty(value = "老许可证号")
    private String oldLicenseCode;

    @ApiModelProperty(value = "经营状态")
    private String statusCode;

    @ApiModelProperty(value = "经营状态描述")
    private String statusCodeText;

    @ApiModelProperty(value = "入网时间")
    private String inNetDate;

    @ApiModelProperty(value = "出网时间")
    private String outNetDate;

    @ApiModelProperty(value = "首次发证日期")
    private String firstAccrediDate;

    @ApiModelProperty(value = "停业开始日期")
    private String applyCloseStart;

    @ApiModelProperty(value = "停业结束日期")
    private String applyCloseEnd;

    @ApiModelProperty(value = "供货单位")
    private String busiCorpName;

    @ApiModelProperty(value = "特殊群体类型")
    private String colonyCode;

    @ApiModelProperty(value = "特殊群体类型描述")
    private String colonyCodeText;

    @ApiModelProperty(value = "特殊群体其它情况说明")
    private String colonyOtherRemark;

    @ApiModelProperty(value = "行政区域编码")
    private String areaCode;

    @ApiModelProperty(value = "行政区域简称")
    private String areaName;

    @ApiModelProperty(value = "行政区划（街道）")
    private String streetCode;

    @ApiModelProperty(value = "行政区域（社区）")
    private String villageCode;

    @ApiModelProperty(value = "享受合理布局照顾政策")
    private String reasonablePolicy;

    @ApiModelProperty(value = "市场类型")
    private String marketType;

    @ApiModelProperty(value = "市场类型描述")
    private String marketTypeText;

    @ApiModelProperty(value = "市场类型细分")
    private String subMarketType;

    @ApiModelProperty(value = "市场类型细分描述")
    private String subMarketTypeText;

    @ApiModelProperty(value = "销售统计口径")
    private String statisticsCode;

    @ApiModelProperty(value = "销售统计口径描述")
    private String statisticsCodeText;

    @ApiModelProperty(value = "新开户")
    private String isNewLice;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否暂停订货")
    private String isSuspendOrder;

    @ApiModelProperty(value = "暂停订货开始日期")
    private String suspendBeginDate;

    @ApiModelProperty(value = "暂停订货结束日期")
    private String suspendEndDate;

    @ApiModelProperty(value = "是否正常可用")
    private String isActive;

    @ApiModelProperty(value = "客户呼出分组")
    private String calloutGroup;

    @ApiModelProperty(value = "所属营销线")
    private String salerDeptUuid;

    @ApiModelProperty(value = "所属稽查线")
    private String auditDeptUuid;

    @ApiModelProperty(value = "所属送货线")
    private String deliverDeptUuid;

    @ApiModelProperty(value = "所属电访线")
    private String agentDeptUuid;

    @ApiModelProperty(value = "所属营销线名称")
    private String salerDeptUuidName;

    @ApiModelProperty(value = "所属稽查线名称")
    private String auditDeptUuidName;

    @ApiModelProperty(value = "所属送货线名称")
    private String deliverDeptUuidName;

    @ApiModelProperty(value = "所属电访线名称")
    private String agentDeptUuidName;

    @ApiModelProperty(value = "订货序号")
    private Long agentOrderNo;

    @ApiModelProperty(value = "送货顺序")
    private Long deliverOrder;

    @ApiModelProperty(value = "送货员")
    private String deliverName;

    @ApiModelProperty(value = "专卖管理员id")
    private String zmManager;

    @ApiModelProperty(value = "稽查员")
    private String checkManName;

    @ApiModelProperty(value = "客户经理人员id")
    private String custManagerPersonUuid;

    @ApiModelProperty(value = "客户经理")
    private String custManagerName;

    @ApiModelProperty(value = "电话订货员")
    private String agentName;

    @ApiModelProperty(value = "国家局分类类别")
    private String custStateType;

    @ApiModelProperty(value = "客户分类类别")
    private String custTypeUuid;

    @ApiModelProperty(value = "客户分类名称")
    private String custTypeName;

    @ApiModelProperty(value = "订货方式")
    private String orderTypeCode;

    @ApiModelProperty(value = "订货方式描述")
    private String orderTypeCodeText;

    @ApiModelProperty(value = "电话订货帐号")
    private String telOrderAccount;

    @ApiModelProperty(value = "电话订货密码")
    private String telOrderPwd;

    @ApiModelProperty(value = "拜访周期类型")
    private String visitCycleType;

    @ApiModelProperty(value = "拜访周期类型描述")
    private String visitCycleTypeText;

    @ApiModelProperty(value = "拜访日")
    private String visitWeekday;

    @ApiModelProperty(value = "拜访日描述")
    private String visitWeekdayText;

    @ApiModelProperty(value = "拜访周次")
    private BigDecimal visitWeekno;

    @ApiModelProperty(value = "拜访周期起始日")
    private String visitBeginDate;

    @ApiModelProperty(value = "拜访序号")
    private Long visitOrder;

    @ApiModelProperty(value = "客户评价类别")
    private String appraiseCode;

    @ApiModelProperty(value = "客户评价类别描述")
    private String appraiseCodeText;

    @ApiModelProperty(value = "第一次订货时间")
    private String firstOrderTime;

    @ApiModelProperty(value = "最后一次订货时间")
    private String lastOrderTime;

    @ApiModelProperty(value = "送货方式 ")
    private String deliverTypeCode;

    @ApiModelProperty(value = "送货方式描述")
    private String deliverTypeCodeText;

    @ApiModelProperty(value = "送货方式")
    private String deliverModeCode;

    @ApiModelProperty(value = "委托代收点")
    private String entrustedPoint;

    @ApiModelProperty(value = "物流停车坐标（经度）")
    private BigDecimal parkingGislong;

    @ApiModelProperty(value = "物流停车坐标（纬度）")
    private BigDecimal parkingGislat;

    @ApiModelProperty(value = "订货周期起始日")
    private String orderBeginDate;

    @ApiModelProperty(value = "订货周期类型")
    private String orderCycleType;

    @ApiModelProperty(value = "订货周期类型描述")
    private String orderCycleTypeText;

    @ApiModelProperty(value = "订货日")
    private String orderWeekday;

    @ApiModelProperty(value = "订货日描述")
    private String orderWeekdayText;

    @ApiModelProperty(value = "订货周次")
    private BigDecimal orderWeekno;

    @ApiModelProperty(value = "订货时间段")
    private String orderDayTime;

    @ApiModelProperty(value = "订货时间段描述")
    private String orderDayTimeText;

    @ApiModelProperty(value = "是否允许销售雪茄烟")
    private String isSaleCigar;

    @ApiModelProperty(value = "是否信息采集点")
    private String isCollect;

    @ApiModelProperty(value = "数采方式")
    private String dataGatherType;

    @ApiModelProperty(value = "数采方式描述")
    private String dataGatherTypeText;

    @ApiModelProperty(value = "终端类别（终端层级）")
    private String terminalLevel;

    @ApiModelProperty(value = "终端类别（终端层级）描述")
    private String terminalLevelText;

    @ApiModelProperty(value = "是否样本户")
    private String isSampleCust;

    @ApiModelProperty(value = "样本户级别")
    private String sampleLevel;

    @ApiModelProperty(value = "样本户级别描述")
    private String sampleLevelText;

    @ApiModelProperty(value = "是否支付宝签约客户")
    private String isZfb;

    @ApiModelProperty(value = "支付方式")
    private String payMode;

    @ApiModelProperty(value = "支付方式描述")
    private String payModeText;

    @ApiModelProperty(value = "银行帐户开户状态")
    private String bankStatus;

    @ApiModelProperty(value = "银行帐户开户状态描述")
    private String bankStatusText;

    @ApiModelProperty(value = "税务开票电话")
    private String taxTel;

    @ApiModelProperty(value = "税务登记号")
    private String taxCode;

    @ApiModelProperty(value = "开户银行与账号")
    private String bankAccountInfo;

    @ApiModelProperty(value = "发票类型")
    private String invoiceType;

    @ApiModelProperty(value = "发票类型描述")
    private String invoiceTypeText;

    @ApiModelProperty(value = "纳税性质")
    private String ratePayType;

    @ApiModelProperty(value = "纳税性质描述")
    private String ratePayTypeText;

    @ApiModelProperty(value = "发票配送方式")
    private String invoiceDistrCode;

    @ApiModelProperty(value = "发票配送方式描述")
    private String invoiceDistrCodeText;

    @ApiModelProperty(value = "是否允许网上结算")
    private String isnetpay;

    @ApiModelProperty(value = "默认银行标识")
    private String bankUuid;

    @ApiModelProperty(value = "默认银行名称")
    private String bankName;

    @ApiModelProperty(value = "银行帐号")
    private String bankAccount;

    @ApiModelProperty(value = "证件号码")
    private String bankIdCard;

    @ApiModelProperty(value = "证件号码")
    private String bankcardOwner;

    @ApiModelProperty(value = "账户类型")
    private String accountType;

    @ApiModelProperty(value = "账户类型描述")
    private String accountTypeText;

    @ApiModelProperty(value = "开户银行数")
    private Long bankcount;

    @ApiModelProperty(value = "存在停用账户")
    private String hasStopped;

    @ApiModelProperty(value = "gis经度")
    private BigDecimal gisLong;

    @ApiModelProperty(value = "gis纬度")
    private BigDecimal gisLat;

    @ApiModelProperty(value = "商圈类型")
    private String positionCode;

    @ApiModelProperty(value = "商圈类型描述")
    private String positionCodeText;

    @ApiModelProperty(value = "次级商圈")
    private String subPositionCode;

    @ApiModelProperty(value = "次级商圈描述")
    private String subPositionCodeText;

    @ApiModelProperty(value = "地段评价")
    private String zoneAppraiseCode;

    @ApiModelProperty(value = "地段评价描述")
    private String zoneAppraiseCodeText;

    @ApiModelProperty(value = "选址")
    private String chooseAddressCode;

    @ApiModelProperty(value = "选址描述")
    private String chooseAddressCodeText;

    @ApiModelProperty(value = "路段类型")
    private String chooseRoadCode;

    @ApiModelProperty(value = "路段类型描述")
    private String chooseRoadCodeText;

    @ApiModelProperty(value = "法人(负责人)姓名")
    private String artificialName;

    @ApiModelProperty(value = "经营者姓名")
    private String managePersonName;

    @ApiModelProperty(value = "法人(负责人)联系电话")
    private String artificialPersonMobile;

    @ApiModelProperty(value = "经营者联系电话")
    private String managePersonMobile;

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

    @ApiModelProperty(value = "拥有者id")
    private String sysowneruuid;

    @ApiModelProperty(value = "部门id")
    private String sysdeptuuid;

    @ApiModelProperty(value = "分公司id")
    private String syscountyuuid;

    @ApiModelProperty(value = "市公司id")
    private String syscompanyuuid;

    @ApiModelProperty(value = "是否允许非烟订货")
    private String isNonsmoke;

    @ApiModelProperty(value = "限供状态")
    private String limitorderType;

    @ApiModelProperty(value = "供货状态")
    private String supplyStatus;

    @ApiModelProperty(value = "地缘情况")
    private String areaTypeDetail;

    @ApiModelProperty(value = "地理环境")
    private String envType;

    @ApiModelProperty(value = "是否实际经营人")
    private String isActualOper;

    @ApiModelProperty(value = "不配合检查")
    private String preventCheck;

    @ApiModelProperty(value = "违法嫌疑户")
    private String suspectRetail;

    @ApiModelProperty(value = "隐性关联户")
    private String hideChain;

    @ApiModelProperty(value = "省重点流通企业")
    private BigDecimal isImportant;

    @ApiModelProperty(value = "连续未订货时间")
    private String unOrderTime;

    @ApiModelProperty(value = "疑似停业")
    private BigDecimal isSuspectCloded;

    @ApiModelProperty(value = "异常客户")
    private BigDecimal isAbnormal;

    @ApiModelProperty(value = "二维码卡制卡")
    private String isQrCard;

    @ApiModelProperty(value = "nfc卡号")
    private String nfcNo;

    @ApiModelProperty(value = "送货周期")
    private String deleverCycle;

    @ApiModelProperty(value = "停车地址")
    private String parkingAddress;

    @ApiModelProperty(value = "送货地址")
    private String deleverAddress;

    @ApiModelProperty(value = "所属站点")
    private String busStop;

    @ApiModelProperty(value = "送货日")
    private String deleverDate;

    @ApiModelProperty(value = "是否送货")
    private String isDelivering;

    @ApiModelProperty(value = "终端层级大类")
    private String terminalLevelfirst;

    @ApiModelProperty(value = "客户店招名称")
    private String shopName;

    @ApiModelProperty(value = "是否价格采集户")
    private String isPricecollect;

    @ApiModelProperty(value = "经营状态（专卖）")
    private String statusCodeZm;

    @ApiModelProperty(value = "发证机关id")
    private String issueOrgUuid;

    @ApiModelProperty(value = "领证送达日期")
    private String deliveryDate;

    @ApiModelProperty(value = "近亲属持证经营")
    private String isRelativesMgt;

    @ApiModelProperty(value = "近亲属姓名")
    private String relativesName;

    @ApiModelProperty(value = "与近亲属关系")
    private String relativesRel;

    @ApiModelProperty(value = "经营场所基站经度")
    private BigDecimal staLongitude;

    @ApiModelProperty(value = "经营场所基站维度")
    private BigDecimal staLatitude;

    @ApiModelProperty(value = "检查次数")
    private BigDecimal checksNum;

    @ApiModelProperty(value = "处罚次数")
    private BigDecimal penaltiesNum;

    @ApiModelProperty(value = "发票抬头")
    private String taxCustName;

    @ApiModelProperty(value = "发票地址")
    private String taxAddress;

    @ApiModelProperty(value = "订单周期编号")
    private String orderPeriodUuid;

    @ApiModelProperty(value = "大户")
    private String largerSaleVolumn;

    @ApiModelProperty(value = "管理单元名称")
    private String manageUnitName;

    private String isSeasonCust;

    private String terminalSurveyorPole;

    private String invoiceCustUuid;

    private String invoiceAffiliation;

    private String creditclassUuid;

    private String creditclassName;

    private String creditScore;

    private String instanceUuid;

    private String cigaTypeUuid;

    private String cigaTypeName;

    private String seasonType;

    private String isAllowOrder;

    private String cigaTypeUuidB;

    private String cigaTypeNameB;

    private String cigaTypeUuidC;

    private String cigaTypeNameC;

    @ApiModelProperty(value = "订货周期")
    private String periodName;

    private String areaPositionType;

    private String areaFuncType;

    private String communityFuncType;

    private String loanpay;

    private String specialCust;

    private String specialCustType;

    private String cigaTypeUuidD;

    private String cigaTypeNameD;

    private String cstDate1;


}


package com.zsc.externalservice.mapper;

import com.zsc.externalservice.entity.AdsSjzlUcCstCustomer;
import com.zsc.externalservice.entity.external.CustomerDetails;
import com.zsc.externalservice.entity.external.CustomerInfo;
import com.zsc.externalservice.entity.external.CustomerInfo_2;
import com.zsc.externalservice.entity.external.SalesSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper {
    @Select("SELECT CUST_NAME, CREDIT_SCORE, TRADE_MODE_CODE_TEXT, LICENSE_CODE " +
            "FROM ADS_SJZL_UC_CST_CUSTOMER " +
            "WHERE CUST_UUID = #{custUuid} " +
            "ORDER BY pdate DESC " +
            "LIMIT 1")
    CustomerInfo findCustomerByCustUuid(String custUuid);

    @Select("SELECT CUST_NAME, license_end_date, ciga_type_name, LICENSE_CODE, ADDRESS, CUST_CODE"
            + " FROM ADS_SJZL_UC_CST_CUSTOMER "
            + "WHERE CUST_UUID = #{custUuid} "
            + "ORDER BY PDATE DESC "
            + "LIMIT 1")
    CustomerInfo_2 findCustomerByCustUuid_2(String custUuid);

//    @Select("SELECT order_weekday FROM ADS_SJZL_UC_CST_CUSTOMER WHERE cust_uuid = #{custUuid}")
//    String findOrderWeekdayByCustUuid(String custUuid);

    @Select("SELECT " +
            "o.pdate, " +
            "o.sum_qty, " +
            "o.sum_branch_qty, " +
            "o.sum_nowithtaxamt, " +
            "o.notaxprice " +
            "FROM ADS_SJZL_XS_SAL_ORDERDTL o " +
            "WHERE o.customer_uuid = #{custUuid} " +
            "AND o.pdate IN " +
            "(SELECT c.order_weekday FROM ADS_SJZL_UC_CST_CUSTOMER c WHERE c.cust_uuid = #{custUuid})")
    List<SalesSummary> getOrderByCustUuid(String custUuid);


    @Select("SELECT deliver_name, zm_manager, cust_manager_name"
            + " FROM ADS_SJZL_UC_CST_CUSTOMER "
            + "WHERE CUST_UUID = #{custUuid} "
            + "ORDER BY PDATE DESC "
            + "LIMIT 1")
    CustomerDetails getCustomerDetailsCustUuid(String custUuid);

    @Select("select * from ADS_SJZL_UC_CST_CUSTOMER where status_code = '01'")
    List<AdsSjzlUcCstCustomer> getCustomers();
}


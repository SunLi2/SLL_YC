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

    CustomerInfo findCustomerByCustUuid(String custUuid);

    CustomerInfo_2 findCustomerByCustUuid_2(String custUuid);

    List<SalesSummary> getOrderByCustUuid(String custUuid);

    CustomerDetails getCustomerDetailsCustUuid(String custUuid);

    List<AdsSjzlUcCstCustomer> getCustomers();
}


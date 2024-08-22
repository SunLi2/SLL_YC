package com.zsc.externalservice.services;

import com.zsc.externalservice.entity.external.CustomerDetails;
import com.zsc.externalservice.entity.external.CustomerInfo;
import com.zsc.externalservice.entity.external.CustomerInfo_2;
import com.zsc.externalservice.entity.external.SalesSummary;
import com.zsc.externalservice.entity.vo.CustomerVO;

import java.util.List;

public interface CustomerService{

    CustomerInfo findCustomerByCustUuid(String custUuid);

    CustomerInfo_2 findCustomerByCustUuid_2(String custUuid);

    List<SalesSummary> getOrderByCustUuid(String custUuid);

    CustomerDetails getCustomerDetailsCustUuid(String custUuid);

    /**
     * 获取商户信息
     * @return
     */
    List<CustomerVO> getCustomerVOList();
}

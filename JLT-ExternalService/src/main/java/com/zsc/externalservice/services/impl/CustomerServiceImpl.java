package com.zsc.externalservice.services.impl;


import com.zsc.externalservice.entity.AdsSjzlUcCstCustomer;
import com.zsc.externalservice.entity.external.CustomerDetails;
import com.zsc.externalservice.entity.external.CustomerInfo;
import com.zsc.externalservice.entity.external.CustomerInfo_2;
import com.zsc.externalservice.entity.external.SalesSummary;
import com.zsc.externalservice.entity.vo.CustomerVO;
import com.zsc.externalservice.mapper.CustomerMapper;

import com.zsc.externalservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerInfo findCustomerByCustUuid(String custUuid) {
        return customerMapper.findCustomerByCustUuid(custUuid);
    }

    @Override
    public CustomerInfo_2 findCustomerByCustUuid_2(String custUuid) {
        return customerMapper.findCustomerByCustUuid_2(custUuid);
    }

    @Override
    public List<SalesSummary> getOrderByCustUuid(String custUuid) {
        return customerMapper.getOrderByCustUuid(custUuid);
    }

    @Override
    public CustomerDetails getCustomerDetailsCustUuid(String custUuid) {
        return customerMapper.getCustomerDetailsCustUuid(custUuid);
    }

    /**
     * 获取商户信息
     * @return
     */
    @Override
    public List<CustomerVO> getCustomerVOList() {
        List<AdsSjzlUcCstCustomer> list = customerMapper.getCustomers();
        List<CustomerVO> result = new ArrayList<>();

        for (AdsSjzlUcCstCustomer a : list) {
            CustomerVO customerVO = CustomerVO.builder()
                    .custUuid(a.getCustUuid())
                    .licenseCode(a.getLicenseCode())
                    .custCode(a.getCustCode())
                    .custName(a.getCustName())
                    .address(a.getAddress())
                    .cigarGrade(null)
                    .licenseEndDate(a.getLicenseEndDate())
                    .build();
            result.add(customerVO);
        }
        return result;
    }

}

package com.zsc.externalservice.controller;


import com.zsc.externalservice.entity.external.CustomerDetails;
import com.zsc.externalservice.entity.external.CustomerInfo;
import com.zsc.externalservice.entity.external.CustomerInfo_2;
import com.zsc.externalservice.entity.external.SalesSummary;
import com.zsc.externalservice.entity.vo.CustomerVO;
import com.zsc.externalservice.services.impl.CustomerServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Api(tags = "获取用户相关信息接口")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

//    curl -X POST "http://localhost:8082/api/customers/getByCustUuid" -H "Content-Type: application/json" -d "00000000000000000000442000100187"


    @PostMapping("/getByCustUuid")
    public CustomerInfo getCustomerByCustUuid(@RequestBody String custUuid) {
        if (custUuid.startsWith("\"") && custUuid.endsWith("\"")) {
            custUuid=custUuid.substring(1, custUuid.length() - 1);
        }
        return customerService.findCustomerByCustUuid(custUuid);
    }

    @PostMapping("/getByCustUuid_2")
    public CustomerInfo_2 getCustomerByCustUuid_2(@RequestBody String custUuid) {
        if (custUuid.startsWith("\"") && custUuid.endsWith("\"")) {
            custUuid=custUuid.substring(1, custUuid.length() - 1);
        }
        return customerService.findCustomerByCustUuid_2(custUuid);
    }

    @PostMapping("/getOrderByCustUuid")
    public List<SalesSummary> getOrderByCustUuid(@RequestBody String custUuid) {
        if (custUuid.startsWith("\"") && custUuid.endsWith("\"")) {
            custUuid=custUuid.substring(1, custUuid.length() - 1);
        }
        return customerService.getOrderByCustUuid(custUuid);
    }

    @PostMapping("/getCustomerDetailsCustUuid")
//    curl -X POST "http://localhost:8082/api/customers/getCustomerDetailsCustUuid" -H "Content-Type: application/json" -d "00000000000000000000442000100187"
    public CustomerDetails getCustomerDetailsCustUuid(@RequestBody String custUuid) {
        if (custUuid.startsWith("\"") && custUuid.endsWith("\"")) {
            custUuid=custUuid.substring(1, custUuid.length() - 1);
        }
        return customerService.getCustomerDetailsCustUuid(custUuid);
    }

    /**
     * 获取商户信息
     * @return
     */
    @GetMapping("/getCustomInfo")
    @ApiOperation("获取远程数据商户信息数据")
    public List<CustomerVO> getCustomerVOList() {
        return customerService.getCustomerVOList();
    }
}

package com.zsc.wxapp.controller;


import com.zsc.wxapp.entity.external.CustomerDetails;
import com.zsc.wxapp.entity.external.CustomerInfo;
import com.zsc.wxapp.entity.external.CustomerInfo_2;
import com.zsc.wxapp.entity.external.SalesSummary;
import com.zsc.wxapp.exservices.Remote2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private Remote2 remote2;
    @PostMapping("/getCustomerByCustUuid")
//    "http://localhost:8080/api/customers/getCustomerByCustUuid" -H "Content-Type: application/json" -d "00000000000000000000442000100187"
    public CustomerInfo getCustomerByCustUuid(@RequestBody String custUuid) {
        CustomerInfo res=remote2.getCustomerByCustUuid(custUuid);
        return res;
    }

    @PostMapping("/getCustomerByCustUuid_2")
//    "http://localhost:8080/api/customers/getCustomerByCustUuid" -H "Content-Type: application/json" -d "00000000000000000000442000100187"
    public CustomerInfo_2 getCustomerByCustUuid_2(@RequestBody String custUuid) {
        CustomerInfo_2 res=remote2.getCustomerByCustUuid_2(custUuid);
        return res;
    }

    @PostMapping("/getSalesSummaryCustUuid")
//    curl -X POST "http://localhost:8080/api/customers/getSalesSummaryCustUuid" -H "Content-Type: application/json" -d "00000000000000000000442000100400"
    public List<SalesSummary> getSalesSummaryCustUuid(@RequestBody String custUuid) {
        List<SalesSummary> res=remote2.getSalesSummaryByCustUuid(custUuid);
        return res;
    }

    @PostMapping("/getCustomerDetailsCustUuid")
//    "http://localhost:8080/api/customers/getCustomerByCustUuid" -H "Content-Type: application/json" -d "00000000000000000000442000100187"
    public CustomerDetails getCustomerDetailsCustUuid(@RequestBody String custUuid) {
        CustomerDetails res=remote2.getCustomerDetailsCustUuid(custUuid);
        return res;
    }
}

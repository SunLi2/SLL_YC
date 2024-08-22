package com.zsc.wxapp.clients;


import com.zsc.wxapp.config.FeignMultipartSupportConfig;
import com.zsc.wxapp.entity.external.*;
import com.zsc.wxapp.entity.vo.CigaretteVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "JLT-ExternalService", url = "http://localhost:8082" ,configuration= FeignMultipartSupportConfig.class, contextId = "test03")
public interface RemotePriceInfoClient {

    @PostMapping(value = "/api/pricetags/getPriceTagsByNamesss", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Product> getPriceByNames(@RequestBody List<String> names);

    @GetMapping(value ="/api/pricetags/getPriceOverview", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PriceOverview> getPriceOverview();

    @PostMapping(value ="/api/customers/getByCustUuid", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
    CustomerInfo getCustomerByCustUuid(String custUuid);

    @PostMapping(value ="/api/customers/getByCustUuid_2", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
    CustomerInfo_2 getCustomerByCustUuid_2(String custUuid);

    @PostMapping(value ="/api/customers/getOrderByCustUuid", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
    List<SalesSummary> getSalesSummaryByCustUuid(String custUuid);

    @PostMapping(value ="/api/customers/getCustomerDetailsCustUuid", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
    CustomerDetails getCustomerDetailsCustUuid(String custUuid);

    @GetMapping(value = "/api/cigarette/getAll", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CigaretteVO> getAll();

}




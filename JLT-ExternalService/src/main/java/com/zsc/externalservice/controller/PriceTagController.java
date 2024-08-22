package com.zsc.externalservice.controller;


import com.zsc.externalservice.entity.PriceTag;
import com.zsc.externalservice.entity.Product;
import com.zsc.externalservice.entity.PriceOverview;
import com.zsc.externalservice.services.IPriceTagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricetags")
public class PriceTagController {

    @Autowired
    private IPriceTagService priceTagService;

    @PostMapping("/getPriceTagsByNamesss")
    public List<Product> getPriceTagsByNames(@RequestBody List<String> names) {
        List<Product> list = priceTagService.getPriceByNamesss(names);
        return list;
    }
    @GetMapping("/getPriceOverview")
    public List<PriceOverview> getPriceOverview() {
        List<PriceOverview> list=priceTagService.getPriceOverview();
        return list;
    }

    @PostMapping("/receiveData")
    public String receiveData(@RequestBody List<PriceTag> requestData) {
        // 获取 res 字段中的数据
        System.out.println("Received data:");
        for (PriceTag product : requestData) {
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Recognized Price: " + product.getRecognizedPrice());
            System.out.println("PT URL: " + product.getPtUrl());
            System.out.println("Cust UUID: " + product.getCustUuid());
            System.out.println("PT Type: " + product.getPtType());
        }
        // 返回响应
        return "Data received successfully";
    }
}

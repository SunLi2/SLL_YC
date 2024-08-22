package com.zsc.wxapp.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsc.wxapp.clients.RemotePriceInfoClient;
import com.zsc.wxapp.entity.PriceTag;
import com.zsc.wxapp.entity.external.PriceNameData;
import com.zsc.wxapp.entity.external.ProductDetails;
import com.zsc.wxapp.entity.external.PriceOverview;
import com.zsc.wxapp.exservices.Remote2;
import com.zsc.wxapp.mapper.PicUrlMapper;
import com.zsc.wxapp.mapper.PriceTagMapper;
import com.zsc.wxapp.services.IPriceTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PriceTagService implements IPriceTagService {

    @Autowired
    private PriceTagMapper priceTagMapper;
    @Autowired
    private PicUrlMapper picUrlMapper;
    @Autowired
    private Remote2 remote2;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RemotePriceInfoClient remotePriceInfoClient;

    public List<PriceTag> findAll() {
        return priceTagMapper.findAll();
    }

    public int insert(PriceTag priceTag) {

        return priceTagMapper.insert(priceTag);
//        return 0;
    }

    public int deleteById(String id) {
        return priceTagMapper.deleteByPrimaryKey(id);
    }

    public int update(PriceTag priceTag) {
        return priceTagMapper.updateByPrimaryKeySelective(priceTag);
//        return 0;
    }


    @Override
    public List<PriceOverview> updateProductUserRetailPrice(List<PriceOverview> productList) {
        for (PriceOverview product : productList) {
            // 根据product_name查询user_retail_price
            Double userRetailPrice = priceTagMapper.findUserRetailPriceByProductName(product.getProductName());
            // 如果查询到值，则更新Product对象
            if (userRetailPrice != null) {
                System.out.println(userRetailPrice);
                product.setRecognizedPrice(userRetailPrice);
            }
        }
        return productList;
    }

    @Override
    public List<PriceOverview> getPriceOverview() {
        List<PriceOverview> priceOverviewList = remotePriceInfoClient.getPriceOverview();
//        List<priceOverview> priceOverviewList=remote2.getPriceOverview();
        priceOverviewList = updateProductUserRetailPrice(priceOverviewList);
        return priceOverviewList;
    }

    @Override
    public List<PriceNameData> getPriceData(String productUuid) {
        return priceTagMapper.getPriceData(productUuid);
    }

    @Override
    public List<ProductDetails> getProductDetails(String productUuid) {
        return priceTagMapper.getProductDetails(productUuid);
    }

}
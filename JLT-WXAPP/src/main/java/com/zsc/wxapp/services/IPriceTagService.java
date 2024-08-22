package com.zsc.wxapp.services;

import com.zsc.wxapp.entity.PriceTag;
import com.zsc.wxapp.entity.external.PriceNameData;
import com.zsc.wxapp.entity.external.ProductDetails;
import com.zsc.wxapp.entity.external.PriceOverview;

import java.util.List;

public interface IPriceTagService {
//    Map<String, Object> User_WX_Upload(MultipartFile file, String uerid);

    public List<PriceTag> findAll();

    public int insert(PriceTag priceTag);

    public int deleteById(String id);

//    public int update(PriceTag priceTag);

//    String upload(MultipartFile file);

    public List<PriceOverview> updateProductUserRetailPrice(List<PriceOverview> productList);

    public List<PriceOverview> getPriceOverview();

    public List<PriceNameData> getPriceData(String productUuid);

    public List<ProductDetails> getProductDetails(String productUuid);
}

package com.zsc.externalservice.services;



import com.zsc.externalservice.entity.PriceTag;
import com.zsc.externalservice.entity.Product;
import com.zsc.externalservice.entity.PriceOverview;

import java.util.List;

public interface IPriceTagService {
//    public List<PriceTag> findAll();
//
//    public List<PriceTag> getPriceByNamess(List<String> names);

    public List<Product> getPriceByNamesss(List<String> names);

//    public int insert(PriceTag priceTag);
//
//    public int deleteById(String id);
//
//    public int update(PriceTag priceTag);

    public List<PriceOverview> getPriceOverview();
}

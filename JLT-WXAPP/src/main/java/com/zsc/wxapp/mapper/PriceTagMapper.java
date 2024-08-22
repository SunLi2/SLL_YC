package com.zsc.wxapp.mapper;

import com.zsc.wxapp.entity.PriceTag;
import com.zsc.wxapp.entity.external.PriceNameData;
import com.zsc.wxapp.entity.external.ProductDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface PriceTagMapper {
    int deleteByPrimaryKey(String pturl_uuid);

    int insert(PriceTag record);

    int insertSelective(PriceTag record);

    PriceTag selectByPrimaryKey(String pturl_uuid);

    int updateByPrimaryKeySelective(PriceTag record);

    int updateByPrimaryKey(PriceTag record);

    List<PriceTag> findAll();


    String findProductUuidByProductName(String productName);


    Double findUserRetailPriceByProductName(String productName);


    List<PriceNameData> getPriceData(String productUuid);

    List<ProductDetails> getProductDetails(String productUuid);

    void insertPriceTags(List<PriceTag> priceTags);


}

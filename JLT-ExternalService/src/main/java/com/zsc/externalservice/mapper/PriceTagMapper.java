package com.zsc.externalservice.mapper;


import com.zsc.externalservice.entity.Product;
import com.zsc.externalservice.entity.PriceOverview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PriceTagMapper {
//    int deleteByPrimaryKey(String pturlUuid);
//
//    int insert(PriceTag record);
//
//    int updateByPrimaryKeySelective(PriceTag record);
//
//    List<PriceTag> findAll();
//
//    List<PriceTag> getPriceByNamess(List names);

//    @Select("SELECT direct_retail_price FROM ADS_SJZL_CC_TBC_PRODUCT WHERE product_name = #{name}")
//    @Select({
//            "<script>",
//            "SELECT product_name , direct_retail_price , product_uuid",
//            "FROM ADS_SJZL_CC_TBC_PRODUCT",
//            "WHERE product_name IN",
//            "<foreach item='name' index='index' collection='names' open='(' separator=',' close=')'>",
//            "#{name}",
//            "</foreach>",
//            "</script>"
//    })
    List<Product> getPriceByNames(List<String> names);

    @Select("select product_name, direct_retail_price, product_uuid from ADS_SJZL_CC_TBC_PRODUCT where product_name = #{name}")
    List<Product> test(String name);

    @Select("SELECT product_name, retail_price, direct_retail_price, factory_simple_name, price_type_code, product_type_code , product_code FROM ADS_SJZL_CC_TBC_PRODUCT")
//    @Select("select * from ADS_SJZL_CC_TBC_PRODUCT")
//    @Select("SELECT * FROM `ADS_SJZL_CC_TBC_PRODUCT` where product_name LIKE '%中华%'")
    List<PriceOverview> getPriceOverview();



}
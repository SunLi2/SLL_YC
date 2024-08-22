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

    @Select("SELECT product_uuid FROM cigarette_info WHERE brand = #{productName}")
    String findProductUuidByProductName(String productName);

    @Select("SELECT recognized_price FROM Price_Tag WHERE product_name = #{productName}")
    Double findUserRetailPriceByProductName(String productName);

    @Select("SELECT product_upload_date, actual_retail_price " +
            "FROM cigarette_info " +
            "WHERE product_upload_date >= CURDATE() - INTERVAL 90 DAY")
    List<PriceNameData> getPriceData(String productUuid);

    @Select("SELECT direct_retail_price, whole_sale_price, is_province, product_type_code, " +
            "price_type_code_text,  brand_uuid, tar_qty, " +
            "nicotine_qty, spec FROM cigarette_info WHERE product_uuid = #{productUuid}")
    List<ProductDetails> getProductDetails(String productUuid);

    @Insert({
            "<script>",
            "INSERT INTO price_tag (pt_uuid, cust_uuid, pic_urlid, pt_type, product_uuid, pt_create_date, ",
            "recognized_price, product_name, direct_retail_price, cigarette_total_info_uuid, cust_total_info_uuid) VALUES ",
            "<foreach collection='priceTags' item='priceTag' separator=','>",
            "(#{priceTag.pt_uuid}, #{priceTag.cust_uuid}, #{priceTag.pic_urlid}, #{priceTag.pt_type}, ",
            "#{priceTag.product_uuid}, #{priceTag.pt_create_date}, #{priceTag.recognized_price}, ",
            "#{priceTag.product_name}, #{priceTag.direct_retail_price}, #{priceTag.cigarette_total_info_uuid}, ",
            "#{priceTag.cust_total_info_uuid})",
            "</foreach>",
            "</script>"
    })
    void insertPriceTags(List<PriceTag> priceTags);


}
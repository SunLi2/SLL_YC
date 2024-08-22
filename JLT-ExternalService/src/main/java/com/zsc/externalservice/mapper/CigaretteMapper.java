package com.zsc.externalservice.mapper;

import com.zsc.externalservice.entity.AdsSjzlCcTbcProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CigaretteMapper {

    /**
     * 获取所有卷烟信息
     * @return
     */
    @Select("select product_name, direct_retail_price, whole_sale_price, sale_begin_date, price_type_code_text, " +
            "is_active, factory_simple_name, tar_qty, nicotine_qty, product_style_code_text, " +
            "package_qty, package_qty2, product_code from ADS_SJZL_CC_TBC_PRODUCT;")
    List<AdsSjzlCcTbcProduct> getAll();
}

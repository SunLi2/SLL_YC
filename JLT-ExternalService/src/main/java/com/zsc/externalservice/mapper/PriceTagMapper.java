package com.zsc.externalservice.mapper;


import com.zsc.externalservice.entity.Product;
import com.zsc.externalservice.entity.PriceOverview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PriceTagMapper {

    List<Product> getPriceByNames(List<String> names);

    List<Product> test(String name);

    List<PriceOverview> getPriceOverview();



}

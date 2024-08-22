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
    List<AdsSjzlCcTbcProduct> getAll();
}

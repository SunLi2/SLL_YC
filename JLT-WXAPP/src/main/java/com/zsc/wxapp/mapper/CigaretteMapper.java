package com.zsc.wxapp.mapper;

import com.zsc.wxapp.annotation.AutoFill;
import com.zsc.wxapp.entity.Cigarette;
import com.zsc.wxapp.entity.vo.CigaretteVO;
import com.zsc.wxapp.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CigaretteMapper {

    /**
     * 插入一条卷烟数据
     * @param cigaretteVO
     */
    void insert(CigaretteVO cigaretteVO);

    /**
     * 根据卷烟代码获取信息
     * @param productCode 卷烟代码
     * @return Cigarette
     */
    @Select("select * from cigarette where product_code = #{productCode}")
    Cigarette getByCode(String productCode);

    /**
     * 根据卷烟代码获取信息
     * @param productCode
     * @return
     */
    @Select("select * from cigarette where product_code = #{productCode}")
    Cigarette getInfo(String productCode);
}

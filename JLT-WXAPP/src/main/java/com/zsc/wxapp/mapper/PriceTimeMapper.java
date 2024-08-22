package com.zsc.wxapp.mapper;

import com.github.pagehelper.Page;
import com.zsc.wxapp.annotation.AutoFill;
import com.zsc.wxapp.entity.PriceTime;
import com.zsc.wxapp.entity.dto.PricePageDTO;
import com.zsc.wxapp.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface PriceTimeMapper {

    /**
     * 查询某天的卷烟价格数据
     * @param date 日期
     * @return List<PriceTime>
     */
   
    List<PriceTime> getPriceTime(LocalDate date);

    /**
     * 插入当天的卷烟价格数据
     * @param priceTime 卷烟价格
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(PriceTime priceTime);

    /**
     * 分页查询数据
     * @param pricePageDTO
     * @return
     */
    Page<PriceTime> PageQuery(PricePageDTO pricePageDTO);

    /**
     * 获取商品在前一天的数据
     * @param code
     * @param date
     * @return
     */
   
    PriceTime getLastPriceTime(String name, LocalDate date);

    /**
     * 根据id获取到卷烟名称
     * @param id
     * @return
     */

    String getPriceTimeById(Integer id);

    /**
     * 根据卷烟名称获取到近日卷烟价格
     * @param productName
     * @return
     */

    List<PriceTime> getPriceTimeList(String productName);
}

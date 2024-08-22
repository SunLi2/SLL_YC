package com.zsc.wxapp.services;

import com.zsc.wxapp.entity.PageResult;
import com.zsc.wxapp.entity.PriceTime;
import com.zsc.wxapp.entity.dto.PricePageDTO;
import com.zsc.wxapp.entity.vo.BrandFluctuateNumVO;
import com.zsc.wxapp.entity.vo.PriceTimeVO;

import java.util.List;

public interface PriceTimeService {

    /**
     * 比较价格浮动品牌数量
     * @return
     */
    BrandFluctuateNumVO comparePricesNum();

    /**
     * 分页查询单日的数据
     * @param pricePageDTO 条件
     * @return PageResult
     */
    PageResult priceTimePage(PricePageDTO pricePageDTO);

    /**
     * 获取近日的价格情况
     * @param id
     * @return
     */
    List<PriceTimeVO> getPriceTimeList(Integer id);
}

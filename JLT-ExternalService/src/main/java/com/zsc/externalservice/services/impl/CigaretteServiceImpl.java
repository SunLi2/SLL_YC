package com.zsc.externalservice.services.impl;

import com.zsc.externalservice.entity.AdsSjzlCcTbcProduct;
import com.zsc.externalservice.entity.vo.CigaretteVO;
import com.zsc.externalservice.mapper.CigaretteMapper;
import com.zsc.externalservice.services.CigaretteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CigaretteServiceImpl implements CigaretteService {

    @Autowired
    private CigaretteMapper cigaretteMapper;

    /**
     * 在远程数据获取到所有香烟消息
     *
     * @return
     */
    @Override
    public List<CigaretteVO> getAll() {
        List<AdsSjzlCcTbcProduct> list = cigaretteMapper.getAll();
        log.info("卷烟消息：{}", list.get(0));
        List<CigaretteVO> result = new ArrayList<>();
        for (AdsSjzlCcTbcProduct a : list) {
            CigaretteVO cigaretteVO = CigaretteVO.builder()
                    .productName(a.getProductName())
                    .directRetailPrice(a.getDirectRetailPrice())
                    .wholeSalePrice(a.getWholeSalePrice())
                    .grossProfitMargin(calculateGrossMargin(a.getRetailPrice(), a.getWholeSalePrice()))
                    .entryTime(a.getSaleBeginDate())
                    .priceType(a.getPriceTypeCodeText())
                    .isOnSale(a.getIsActive())
                    .factoryName(a.getFactorySimpleName())
                    .tarQty(a.getTarQty())
                    .nicotineQty(a.getNicotineQty())
                    .productStyle(a.getProductStyleCodeText())
                    .packageQty(String.valueOf(a.getPackageQty()))
                    .packageQty2(String.valueOf(a.getPackageQty2()))
                    .productCode(a.getProductCode())
                    .build();
            result.add(cigaretteVO);
        }
        return result;
    }

    /**
     * 计算毛利率
     * @param retailPrice
     * @param wholesalePrice
     * @return
     */
    public static String calculateGrossMargin(BigDecimal retailPrice, BigDecimal wholesalePrice) {
        if (wholesalePrice == null || retailPrice == null) {
            return "0%";
        }
        if (retailPrice.compareTo(BigDecimal.ZERO) == 0) {
            // 可以选择抛出自定义异常或返回默认值
            return "0%";
        }
        // 计算毛利
        BigDecimal grossProfit = retailPrice.subtract(wholesalePrice);
        // 计算毛利率
        BigDecimal grossMargin = grossProfit.divide(retailPrice, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));
        return grossMargin + "%";
    }
}

package com.zsc.wxapp.services.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zsc.wxapp.clients.RemotePriceInfoClient;
import com.zsc.wxapp.entity.PageResult;
import com.zsc.wxapp.entity.PriceTime;
import com.zsc.wxapp.entity.dto.PricePageDTO;
import com.zsc.wxapp.entity.external.PriceOverview;
import com.zsc.wxapp.entity.vo.BrandFluctuateNumVO;
import com.zsc.wxapp.entity.vo.PriceTimeVO;
import com.zsc.wxapp.mapper.PriceTimeMapper;
import com.zsc.wxapp.services.PriceTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class PriceTimeServiceImpl implements PriceTimeService {

    @Autowired
    private PriceTimeMapper priceTimeMapper;
    @Autowired
    private RemotePriceInfoClient remotePriceInfoClient;

    /**
     * 连接远程数据库,获取当天的卷烟数据
     */
    public void getLastPriceTime() {
        // 判断是否有当天的数据
        if (!priceTimeMapper.getPriceTime(LocalDate.now()).isEmpty()) {
            log.info("今天已经获取过数据");
            return;
        }

        //连接远程数据库,获取当天的卷烟数据
        log.info("获取今天的卷烟价格数据");
        List<PriceOverview> list = remotePriceInfoClient.getPriceOverview();

        //插入本服务的数据库中
        for (PriceOverview priceOverview : list) {

            PriceTime priceTime = PriceTime.builder()
                    .productName(priceOverview.getProductName())
                    .retailPrice(BigDecimal.valueOf(priceOverview.getRetailPrice()))
                    .directRetailPrice(BigDecimal.valueOf(priceOverview.getDirectRetailPrice()))
                    .factorySimpleName(priceOverview.getFactorySimpleName())
                    .priceTypeCode(priceOverview.getPriceTypeCode())
                    .productTypeCode(priceOverview.getProductTypeCode())
                    .productCode(priceOverview.getProductCode())
                    .build();
            log.info("priceTime:{}", priceTime.getProductName());
            priceTimeMapper.insert(priceTime);
        }
    }

    /**
     * 比较价格浮动品牌数量
     *
     * @return brandFluctuateNumVO
     */
    @Override
    public BrandFluctuateNumVO comparePricesNum() {
        getLastPriceTime();
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        //获取上一天的价格数据
        List<PriceTime> yesterdayPrime = priceTimeMapper.getPriceTime(yesterday);

        //获取今天的价格数据
        List<PriceTime> todayPrime = priceTimeMapper.getPriceTime(today);

        return comparePrices(yesterdayPrime, todayPrime);
    }

    /**
     * 比较价格浮动品牌数量
     *
     * @param yesterdayPrime 昨天价格数据
     * @param todayPrime     今天价格数据
     * @return brandFluctuateNumVO
     */
    private static BrandFluctuateNumVO comparePrices(List<PriceTime> yesterdayPrime, List<PriceTime> todayPrime) {
        Integer up = 0;
        Integer parity = 0;
        Integer down = 0;

        Map<String, BigDecimal> yesterdayPrimeMap = new HashMap<>();
        Map<String, BigDecimal> todayPrimeMap = new HashMap<>();

        // 构建两个映射
        yesterdayPrime.forEach(pp -> yesterdayPrimeMap.put(pp.getProductName(), pp.getRetailPrice()));
        todayPrime.forEach(pp -> todayPrimeMap.put(pp.getProductName(), pp.getRetailPrice()));

        // 检查两个映射中的价格变化
        Set<String> allKeys = new HashSet<>(yesterdayPrimeMap.keySet());
        allKeys.addAll(todayPrimeMap.keySet());

        int i = 0;

        for (String key : allKeys) {
            BigDecimal yesterdayPrice = yesterdayPrimeMap.get(key);
            BigDecimal todayPrice = todayPrimeMap.get(key);

            if (yesterdayPrice == null || todayPrice == null) {
//                log.info("商品已经下架或者商品刚刚上新");
            } else if (yesterdayPrice.compareTo(todayPrice) == 0) {
                // 平价
                parity++;
            } else if (yesterdayPrice.compareTo(todayPrice) > 0) {
                // 上涨
                up++;
            } else if (yesterdayPrice.compareTo(todayPrice) < 0) {
                // 下跌
                down++;
            }
            i++;
        }
//        log.info("共{}个品牌", i);
        return BrandFluctuateNumVO.builder()
                .downNum(down)
                .parityNum(parity)
                .upNum(up)
                .build();
    }

    /**
     * 分页查询单日的数据
     *
     * @param pricePageDTO 条件
     * @return PageResult
     */
    @Override
    public PageResult priceTimePage(PricePageDTO pricePageDTO) {
        PageHelper.startPage(pricePageDTO.getPageNum(), pricePageDTO.getPageSize());

        pricePageDTO.setDate(LocalDate.now());
        Page<PriceTime> list = priceTimeMapper.PageQuery(pricePageDTO);
        Page<PriceTimeVO> page = new Page<>();
        for (PriceTime priceTime : list) {
//            log.info("priceTime:{}", priceTime.getProductName());
            //获取该商品昨天的价格
            BigDecimal yesterdayPrice = priceTimeMapper.getLastPriceTime(priceTime.getProductName(), LocalDate.now().minusDays(1)).getRetailPrice();
            BigDecimal recognized_price = BigDecimal.valueOf(0.00);
            if (yesterdayPrice.compareTo(BigDecimal.ZERO) != 0) {
                recognized_price = (priceTime.getRetailPrice().subtract(yesterdayPrice)).divide(yesterdayPrice, 2, RoundingMode.HALF_UP);
//                log.info("涨幅是：{}", recognized_price);
            }

            PriceTimeVO priceTimeVO = PriceTimeVO.builder()
                    .id(priceTime.getId())
                    .product_name(priceTime.getProductName())
                    .retail_price(priceTime.getRetailPrice())
                    .recognized_price(recognized_price)
                    .direct_retail_price(priceTime.getDirectRetailPrice())
                    .refer_gross_profit_margin(BigDecimal.valueOf(0.19))
                    .product_code(priceTime.getProductCode())
                    .build();
            page.add(priceTimeVO);
        }
        page.setTotal(list.getTotal());
//        log.info("查询结构：{}", page);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 获取涨幅
     * @param yesterdayPrice 昨天价格
     * @param todayPrice 今天价格
     * @return 涨幅
     */
    public static BigDecimal getRecognizedPrice(BigDecimal yesterdayPrice, BigDecimal todayPrice) {
        if (yesterdayPrice.compareTo(BigDecimal.ZERO) == 0) {
            //如果昨天没有数据了，直接返回0.00
            return BigDecimal.valueOf(0.00);
        }
        return todayPrice.subtract(yesterdayPrice).divide(yesterdayPrice, 2, RoundingMode.HALF_UP);
    }

    /**
     * 获取近日的价格情况
     * @param id 卷烟价格id
     * @return priceTimeList
     */
    @Override
    public List<PriceTimeVO> getPriceTimeList(Integer id) {
        // 根据id获取到卷烟的名称
        String productName = priceTimeMapper.getPriceTimeById(id);

        // 查询卷烟近日的价格
        List<PriceTime> list = priceTimeMapper.getPriceTimeList(productName);

        //遍历priceTimeList，计算涨幅
        List<PriceTimeVO> priceTimeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            BigDecimal recognizedPrice;
            // 检查是否到达了最后一个元素
            if (i + 1 < list.size()) {
                recognizedPrice = getRecognizedPrice(list.get(i).getRetailPrice(), list.get(i + 1).getRetailPrice());
            } else {
                // 如果是最后一个元素，则设置默认值
                recognizedPrice = BigDecimal.valueOf(0.00);
            }

            PriceTimeVO priceTimeVO = PriceTimeVO.builder()
                    .product_name(list.get(i).getProductName())
                    .retail_price(list.get(i).getRetailPrice())
                    .recognized_price(recognizedPrice)
                    .date(list.get(i).getCreateTime())
                    .build();
            priceTimeList.add(priceTimeVO);
        }

        return priceTimeList;
    }
}

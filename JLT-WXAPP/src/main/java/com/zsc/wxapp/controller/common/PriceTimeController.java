package com.zsc.wxapp.controller.common;

import com.zsc.wxapp.entity.PageResult;
import com.zsc.wxapp.entity.Result;
import com.zsc.wxapp.entity.dto.PricePageDTO;
import com.zsc.wxapp.entity.vo.BrandFluctuateNumVO;
import com.zsc.wxapp.entity.vo.PriceTimeVO;
import com.zsc.wxapp.services.PriceTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/priceTime")
@RestController
@Api(tags = "每日价格相关接口")
@Slf4j
public class PriceTimeController {

    @Autowired
    private PriceTimeService priceTimeService;

    /**
     * 比较价格浮动品牌数量
     * @return
     */
    @GetMapping("/comparePriceNum")
    @ApiOperation("比较价格浮动品牌数量")
    public Result<BrandFluctuateNumVO> comparePricesNum() {
        log.info("比较价格浮动品牌数量");
        BrandFluctuateNumVO brandFluctuateNumVO = priceTimeService.comparePricesNum();
        return Result.success(brandFluctuateNumVO);
    }

    /**
     * 分页查询单日的数据， 包括筛选
     *  TODO 筛选还需完善
     * @return
     */
    @GetMapping("/getPricePage")
    @ApiOperation("分页查询所有卷烟价格")
    public Result<PageResult> getPriceTime(PricePageDTO pricePageDTO) {
        log.info("获取每日价格");
        // 分页查询, 每页数据写死15条
        pricePageDTO.setPageSize(66);
        PageResult pageResult = priceTimeService.priceTimePage(pricePageDTO);
        return Result.success(pageResult);
    }

    /**
     * 获取近日的价格情况
     * @param id 卷烟价格id
     * @return
     */
    @GetMapping("/getPriceTimeInfo")
    @ApiOperation("获取近日的价格情况")
    public Result<List<PriceTimeVO>> getPriceInfo(Integer id) {
        log.info("获取近日的价格情况,传入的id是：{}", id);
        List<PriceTimeVO> priceTimeList = priceTimeService.getPriceTimeList(id);
        return Result.success(priceTimeList);
    }
}

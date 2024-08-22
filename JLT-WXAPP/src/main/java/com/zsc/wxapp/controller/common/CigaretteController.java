package com.zsc.wxapp.controller.common;

import com.zsc.wxapp.entity.Result;
import com.zsc.wxapp.entity.vo.CigaretteVO;
import com.zsc.wxapp.services.CigaretteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cigarette")
@Api(tags = "香烟相关接口")
@Slf4j
public class CigaretteController {

    @Autowired
    private CigaretteService cigaretteService;

    /**
     * 获取所有卷烟消息，插入到数据库中
     * @return
     */
    @GetMapping("/getAll")
    @ApiOperation("获取所有卷烟消息")
    public Result getAll() {
        cigaretteService.getAll();
        return Result.success();
    }

    /**
     * 根据卷烟代码获取卷烟信息
     * @param productCode
     * @return
     */
    @GetMapping("/getCigaretteInfo")
    @ApiOperation("获取卷烟信息")
    @ApiImplicitParam(name = "productCode", value = "卷烟代码", required = true, dataType = "String", paramType = "query")
    public Result<CigaretteVO> getCigaretteInfo(String productCode) {
        log.info("获取卷烟信息，productCode:{}", productCode);
        return Result.success(cigaretteService.getCigaretteInfo(productCode));
    }
}

package com.zsc.externalservice.controller;

import com.zsc.externalservice.entity.vo.CigaretteVO;
import com.zsc.externalservice.services.CigaretteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cigarette")
@Api(tags = "获取香烟消息相关接口")
@Slf4j
public class CigaretteController {

    @Autowired
    private CigaretteService cigaretteService;

    /**
     * 在远程数据获取到所有香烟消息
     * @return
     */
    @GetMapping("/getAll")
    @ApiOperation("获取所有香烟消息")
    public List<CigaretteVO> getAll() {
        return cigaretteService.getAll();
    }
}

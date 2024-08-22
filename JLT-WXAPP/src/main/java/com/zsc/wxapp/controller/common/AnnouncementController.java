package com.zsc.wxapp.controller.common;

import com.zsc.wxapp.entity.Result;
import com.zsc.wxapp.entity.vo.AnnouncementListVO;
import com.zsc.wxapp.entity.vo.AnnouncementVO;
import com.zsc.wxapp.services.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/announcement")
@Api(tags = "公告相关接口")
@Slf4j
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    /**
     * 根据key获取该分类的所有公告
     * @return List<AnnouncementVO>
     */
    @GetMapping("/getByKey/{type}")
    @ApiOperation("根据key获取该分类的所有公告")
    public Result<List<AnnouncementListVO>> getAll(@PathVariable Integer type) {
        log.info("根据key获取该分类的所有公告:{}", type);
        return Result.success(announcementService.getByKey(type));
    }

    /**
     * 根据卷烟id获取相关的公告信息
     * @param productCode 卷烟代码
     * @return AnnouncementVO
     */
    @GetMapping("/getByCigaretteId")
    @ApiOperation("根据卷烟id获取相关的公告信息")
    public Result<List<AnnouncementListVO>> getByCigaretteId(String productCode) {
        log.info("根据卷烟id获取相关的公告信息，productCode:{}", productCode);
        return Result.success(announcementService.getByCigaretteId(productCode));
    }

    /**
     * 获取公告详情
     * @param id 公告id
     * @return AnnouncementVO
     */
    @GetMapping("/getById/{id}")
    @ApiOperation("获取公告详情")
    public Result<AnnouncementVO> getById(@PathVariable Integer id) {
        log.info("获取公告详情,id:{}", id);
        return Result.success(announcementService.getById(id));
    }
}

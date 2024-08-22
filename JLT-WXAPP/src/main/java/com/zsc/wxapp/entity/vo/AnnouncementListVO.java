package com.zsc.wxapp.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnnouncementListVO {

    @ApiModelProperty(value = "公告id")
    private Integer id;

    @ApiModelProperty(value = "类型，公告或者引导指南")
    private Integer type;

    @ApiModelProperty(value = "分类小名")
    private String keyword1;

    @ApiModelProperty(value = "分类小名")
    private String keyword2;

    @ApiModelProperty(value = "标题")
    private String title;
}
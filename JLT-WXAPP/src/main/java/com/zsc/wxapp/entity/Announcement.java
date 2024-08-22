package com.zsc.wxapp.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "$tableInfo.comment")
public class Announcement {

    @ApiModelProperty(value = "公告id")
    private Integer id;

    @ApiModelProperty(value = "如果有公告是绑定烟名的，该字段存储烟的id")
    private Integer cigaretteId;

    @ApiModelProperty(value = "分类：1 是动态， 2 是公告， 3 是 目录， 4 须知")
    private Integer type;

    @ApiModelProperty(value = "分类内容")
    private String keyword1;

    @ApiModelProperty(value = "分类内容2")
    private String keyword2;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发布者")
    private String publisher;

    @ApiModelProperty(value = "发表时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}


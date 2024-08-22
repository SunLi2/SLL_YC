package com.zsc.wxapp.mapper;

import com.zsc.wxapp.entity.PicUrl;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PicUrlMapper {

    // 插入方法
    int insert(PicUrl picUrl);

    // 根据操作者id查询他上传的最新时间的图片url
    PicUrl findByLatestCreatetime(@Param("pic_userid") String userid);

    // 新增方法，根据用户ID查找所有图片URL
    List<PicUrl> findAllPicUrlByUerid(@Param("pic_userid") String userid);

    void insertPicUrls(List<PicUrl> picUrls);


    List<String> findUnusedPicUrls();


    String findUrlById(String jltPicUrlid);


    void deleteById(String jltPicUrlid);

}

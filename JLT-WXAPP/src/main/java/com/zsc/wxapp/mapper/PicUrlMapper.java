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

    @Insert({
            "<script>",
            "INSERT INTO Pic_Url (jlt_pic_urlid, jlt_pic_uid, jlt_pic_url, ljt_pic_creattime) VALUES ",
            "<foreach collection='picUrls' item='picUrl' separator=','>",
            "(#{picUrl.jltPicUrlid}, #{picUrl.jltPicUid}, #{picUrl.jltPicUrl}, #{picUrl.ljtPicCreattime})",
            "</foreach>",
            "</script>"
    })
    void insertPicUrls(List<PicUrl> picUrls);

    @Select("SELECT jlt_pic_urlid FROM pic_url WHERE jlt_pic_urlid NOT IN (SELECT pt_id FROM price_tag1)")
    List<String> findUnusedPicUrls();

    @Select("SELECT jlt_pic_url FROM pic_url WHERE jlt_pic_urlid = #{jltPicUrlid}")
    String findUrlById(String jltPicUrlid);

    @Delete("DELETE FROM pic_url WHERE jlt_pic_urlid = #{jltPicUrlid}")
    void deleteById(String jltPicUrlid);

}
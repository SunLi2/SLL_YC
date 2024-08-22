package com.zsc.wxapp.mapper;



import com.zsc.wxapp.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AnnouncementMapper {

    // 查询所有公告
    List<Announcement> selectAllAnnouncements();

    // 根据公告ID查询单个公告
    Announcement selectAnnouncementByUuid(@Param("a_uuid") String a_uuid);

    // 插入新公告
    int insertAnnouncement(Announcement announcement);

    // 更新公告信息
    int updateAnnouncement(Announcement announcement);

    // 根据公告ID删除公告
    int deleteAnnouncementByUuid(@Param("a_uuid") String a_uuid);

    List<Announcement> findAnnouncementsByType(String a_type);


    /**
     * 根据key获取该分类的所有公告
     * @return List
     */
    @Select("select * from announcement where `type` = #{type} order by create_time desc")
    List<Announcement> getByKey(Integer type);

    /**
     * 根据卷烟ID获取公告
     * @param cigaretteId 卷烟ID
     * @return AnnouncementVO
     */
    @Select("select * from announcement where cigarette_id = #{cigaretteId}")
    List<Announcement> getByCigaretteId(Integer cigaretteId);

    /**
     * 获取公告详情
     * @param id 公告id
     * @return AnnouncementVO
     */
    @Select("select * from announcement where id = #{id}")
    Announcement getById(Integer id);
}
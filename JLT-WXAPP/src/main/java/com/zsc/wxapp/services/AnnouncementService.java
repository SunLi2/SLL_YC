package com.zsc.wxapp.services;

import com.zsc.wxapp.entity.Announcement;
import com.zsc.wxapp.entity.vo.AnnouncementListVO;
import com.zsc.wxapp.entity.vo.AnnouncementVO;

import java.util.List;
import java.util.Map;

public interface AnnouncementService {
    // 查询所有公告
    List<Announcement> findAllAnnouncements();

    Map<String, List<Announcement>> findAllAnnouncementsByType();

    List<Announcement> findAnnouncementsByType(String a_type);

    // 根据ID查询单个公告
    Announcement findAnnouncementByUuid(String a_uuid);

    // 插入新公告
    int saveAnnouncement(Announcement announcement);

    // 更新公告信息
    int updateAnnouncement(Announcement announcement);

    // 根据ID删除公告
    int deleteAnnouncementByUuid(String a_uuid);

    /**
     * 根据key获取该分类的所有公告
     * @param key 分类key
     * @return List
     */
    List<AnnouncementListVO> getByKey(Integer key);

    /**
     * 根据卷烟ID获取公告
     * @param cigaretteId 卷烟ID
     * @return AnnouncementVO
     */
    List<AnnouncementListVO> getByCigaretteId(String productCode);

    /**
     * 获取公告详情
     * @param id 公告id
     * @return AnnouncementVO
     */
    AnnouncementVO getById(Integer id);
}

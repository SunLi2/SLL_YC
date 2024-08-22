package com.zsc.wxapp.services.impl;

import com.zsc.wxapp.entity.Announcement;
import com.zsc.wxapp.entity.vo.AnnouncementListVO;
import com.zsc.wxapp.entity.vo.AnnouncementVO;
import com.zsc.wxapp.mapper.AnnouncementMapper;
import com.zsc.wxapp.mapper.CigaretteMapper;
import com.zsc.wxapp.services.AnnouncementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;
    @Autowired
    private CigaretteMapper cigaretteMapper;

    /**
     * 根据key获取该分类的所有公告
     * @param type 分类key
     * @return List
     */
    @Override
    public List<AnnouncementListVO> getByKey(Integer type) {
        List<Announcement> list = announcementMapper.getByKey(type);
        List<AnnouncementListVO> announcements = new ArrayList<>();

        for (Announcement announcement : list) {
            AnnouncementListVO a = new AnnouncementListVO();
            BeanUtils.copyProperties(announcement, a);
            announcements.add(a);
        }
        return announcements;
    }

    /**
     * 根据卷烟ID获取公告
     * @param productCode 卷烟代码
     * @return AnnouncementVO
     */
    @Override
    public List<AnnouncementListVO> getByCigaretteId(String productCode) {
        //根据卷烟的productCode获取卷烟的id TODO
        Integer id = cigaretteMapper.getByCode(productCode).getId();

        List<Announcement> announcements = announcementMapper.getByCigaretteId(id);
        List<AnnouncementListVO> result = new ArrayList<>();
        if (announcements.isEmpty()) {
            return null;
        }
        for (Announcement announcement : announcements) {
            AnnouncementListVO a = new AnnouncementListVO();
            BeanUtils.copyProperties(announcement, a);
            result.add(a);
        }
        return result;
    }

    /**
     * 获取公告详情
     * @param id 公告id
     * @return AnnouncementVO
     */
    @Override
    public AnnouncementVO getById(Integer id) {
        Announcement announcement = announcementMapper.getById(id);
        AnnouncementVO result = new AnnouncementVO();
        if (announcement != null) {
            BeanUtils.copyProperties(announcement, result);
            return result;
        }
        return null;
    }

    @Override
    public List<Announcement> findAllAnnouncements() {
        List<Announcement> announcements = announcementMapper.selectAllAnnouncements();

        return announcements;
    }
    @Override
    public Map<String, List<Announcement>> findAllAnnouncementsByType() {
        Map<String, List<Announcement>> response = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            String a_type = i + "";
            System.out.println("a_type: "+a_type);
            List<Announcement> announcementsByType = announcementMapper.findAnnouncementsByType(a_type);
            response.put("announcement" + i, announcementsByType);
        }
        return response;
    }

    @Override
    public List<Announcement> findAnnouncementsByType(String a_type) {
        return announcementMapper.findAnnouncementsByType(a_type);
    }

    @Override
    public Announcement findAnnouncementByUuid(String a_uuid) {
        return announcementMapper.selectAnnouncementByUuid(a_uuid);
    }

    @Override
    public int saveAnnouncement(Announcement announcement) {
        return announcementMapper.insertAnnouncement(announcement);
    }

    @Override
    public int updateAnnouncement(Announcement announcement) {
        return announcementMapper.updateAnnouncement(announcement);
    }

    @Override
    public int deleteAnnouncementByUuid(String a_uuid) {
        return announcementMapper.deleteAnnouncementByUuid(a_uuid);
    }


}

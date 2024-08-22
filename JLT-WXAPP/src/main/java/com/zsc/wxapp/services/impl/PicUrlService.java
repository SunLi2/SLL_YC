package com.zsc.wxapp.services.impl;

import com.zsc.wxapp.entity.PicUrl;
import com.zsc.wxapp.mapper.PicUrlMapper;
import com.zsc.wxapp.services.IPicUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicUrlService implements IPicUrlService {


    @Autowired
    private PicUrlMapper picUrlMapper;


    @Override
    public List<PicUrl> findAllPicUrlByUerid(String userid) {

        List<PicUrl> picUrls = picUrlMapper.findAllPicUrlByUerid(userid);

        return picUrls;
    }

    @Override
    public PicUrl findByLatestCreatetime(String userid) {
        return picUrlMapper.findByLatestCreatetime(userid);
    }
}
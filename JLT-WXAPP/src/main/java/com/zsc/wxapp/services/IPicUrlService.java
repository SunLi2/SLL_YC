package com.zsc.wxapp.services;


import com.zsc.wxapp.entity.PicUrl;

import java.util.List;

public interface IPicUrlService {


    public List<PicUrl> findAllPicUrlByUerid(String   userid);

    // 根据操作者id查询他上传的最新时间的图片url
    PicUrl findByLatestCreatetime( String userid);
}

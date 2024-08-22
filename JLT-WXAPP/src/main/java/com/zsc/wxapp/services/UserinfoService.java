package com.zsc.wxapp.services;

import com.zsc.wxapp.entity.Userinfo;
import com.zsc.wxapp.entity.dto.UserLoginDTO;

public interface UserinfoService {

    /**
     * 用户登录
     * @param userLoginDTO 用户登录信息
     * @return Userinfo
     */
    Userinfo login(UserLoginDTO userLoginDTO);
}

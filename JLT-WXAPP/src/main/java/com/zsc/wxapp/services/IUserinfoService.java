package com.zsc.wxapp.services;

import com.zsc.wxapp.entity.Userinfo;

public interface IUserinfoService {
    Userinfo login(String phone);
}

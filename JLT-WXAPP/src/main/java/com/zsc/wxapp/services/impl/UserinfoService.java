package com.zsc.wxapp.services.impl;

import com.zsc.wxapp.entity.Userinfo;
import com.zsc.wxapp.mapper.UserinfoMapper;
import com.zsc.wxapp.services.IUserinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserinfoService implements IUserinfoService {

    private final UserinfoMapper userinfoMapper;


    @Override
    public Userinfo login(String phone) {
        return userinfoMapper.selectUserByPhone(phone);
    }
}

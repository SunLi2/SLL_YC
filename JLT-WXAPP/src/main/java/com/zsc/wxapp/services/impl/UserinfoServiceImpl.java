package com.zsc.wxapp.services.impl;

import com.zsc.wxapp.entity.Userinfo;
import com.zsc.wxapp.entity.dto.UserLoginDTO;
import com.zsc.wxapp.mapper.UserinfoMapper;
import com.zsc.wxapp.services.UserinfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    public UserinfoMapper userinfoMapper;

    /**
     * 用户登录
     * @param userLoginDTO 用户登录信息
     * @return Userinfo
     */
    @Override
    public Userinfo login(UserLoginDTO userLoginDTO) {
        Userinfo userinfo = userinfoMapper.selectUserByPhone(userLoginDTO.getPhone());

        if (userinfo == null) {
            throw new RuntimeException("该手机还没注册账号！");
        }

        String password = userLoginDTO.getPassword();
        if (password.equals(userinfo.getPassword())) {
            //密码正确，登录成功
            return userinfo;
        } else {
            throw new RuntimeException("密码错误！");
        }
    }
}

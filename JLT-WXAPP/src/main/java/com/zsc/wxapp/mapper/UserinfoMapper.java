package com.zsc.wxapp.mapper;

import com.zsc.wxapp.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserinfoMapper {

    @Select("select * from userinfo where phone = #{phone}")
    Userinfo selectUserByPhone(String phone);
}
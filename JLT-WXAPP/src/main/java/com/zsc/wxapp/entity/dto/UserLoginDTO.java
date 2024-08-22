package com.zsc.wxapp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录传输数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    //手机号
    private String phone;
    //密码
    private String password;
}

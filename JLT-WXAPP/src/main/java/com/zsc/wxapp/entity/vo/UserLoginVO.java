package com.zsc.wxapp.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginVO {

    // TODO 待完善，返回个人的所有信息给前端，用于 “我的” 界面
    private Long userId;

    private String phone;

    private String token;
}

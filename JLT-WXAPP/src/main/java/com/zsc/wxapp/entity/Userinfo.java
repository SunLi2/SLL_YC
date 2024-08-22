package com.zsc.wxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Userinfo {
    Long userId; // 账号
    String profilePhotoUrl; // 用户头像
    String phone; // 手机
    String password; //密码
    String roleId; // 权限 (FK)
    int isVip; // 是否vip
    String vipEndTime; // vip结束时间
    String shopName; // 店铺名字/如果是其他角色，角色名
    String principalName; // 店铺人的名字，稽查人员的名字
    int isValid; // 账号状态
    String customUuid; // 客户标识,用户表主键
    String registerTime; // 注册时间
    int photoCount; // 累计拍照次数
    int vipRewardDays; // 奖励vip天数
}
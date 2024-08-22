package com.zsc.wxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dailyquotes {
        String dq_uuid; // 每日行情表主键
        String dq_statistical_time; // 每日行情表统计的日期
        int dq_unchanged_price; // 统计不变价格的烟的种类数量
        int dq_rise_price; // 统计上涨价格的烟的种类数量
        int dq_decline_price; // 统计下降价格的烟的种类数量
        double dq_profit; // 统计用户有的烟的盈利情况
}
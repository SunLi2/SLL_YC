package com.zsc.wxapp.services.impl;

import com.zsc.wxapp.entity.Dailyquotes;
import com.zsc.wxapp.mapper.DailyquotesMapper;
import com.zsc.wxapp.services.IDailyquotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DailyquotesService implements IDailyquotesService {
    @Autowired
    private DailyquotesMapper dailyquotesMapper;
    @Override
    public Dailyquotes findCurrentDailyquotes() {
        // 查找当天行情
        ZonedDateTime beijingDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dq_statistical_time = beijingDateTime.format(formatter);
        return dailyquotesMapper.selectDailyquotesByStatisticalTime(dq_statistical_time);
    }
}

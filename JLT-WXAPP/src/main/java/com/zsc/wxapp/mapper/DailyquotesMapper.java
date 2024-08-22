package com.zsc.wxapp.mapper;

import com.zsc.wxapp.entity.Dailyquotes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyquotesMapper {

    // 查询所有每日行情信息
    List<Dailyquotes> selectAllDailyquotes();

    // 根据统计日期查询每日行情信息
    Dailyquotes selectDailyquotesByStatisticalTime(String dq_statistical_time);

    // 插入新的每日行情信息
    int insertDailyquotes(Dailyquotes dailyquotes);

    // 更新每日行情信息
    int updateDailyquotes(Dailyquotes dailyquotes);

    // 根据UUID删除每日行情信息
    int deleteDailyquotesByUuid(String uuid);
}
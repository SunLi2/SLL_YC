package com.zsc.wxapp.services.impl;

import com.zsc.wxapp.clients.RemotePriceInfoClient;
import com.zsc.wxapp.entity.Cigarette;
import com.zsc.wxapp.entity.vo.CigaretteVO;
import com.zsc.wxapp.mapper.CigaretteMapper;
import com.zsc.wxapp.services.CigaretteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CigaretteServiceImpl implements CigaretteService {

    @Autowired
    private RemotePriceInfoClient remotePriceInfoClient;
    @Autowired
    private CigaretteMapper cigaretteMapper;

    @Override
    public void getAll() {
        List<CigaretteVO> list = remotePriceInfoClient.getAll();
//        log.info("获取所有卷烟信息:{}", list.get(0));
        for (CigaretteVO cigaretteVO : list) {
            //TODO 每日更新一遍，获取最新的数据
//            cigaretteMapper.insert(cigaretteVO);
        }
    }

    /**
     * 根据卷烟代码获取卷烟信息
     * @param productCode
     * @return
     */
    @Override
    public CigaretteVO getCigaretteInfo(String productCode) {
        Cigarette cigarette = cigaretteMapper.getInfo(productCode);
        log.info("查询到的数据为，cigarette:{}", cigarette);
        CigaretteVO result = new CigaretteVO();
        BeanUtils.copyProperties(cigarette, result);

        return result;
    }
}

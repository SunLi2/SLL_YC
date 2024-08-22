package com.zsc.wxapp.services;

import com.zsc.wxapp.entity.vo.CigaretteVO;

public interface CigaretteService {

    void getAll();

    /**
     * 根据code获取卷烟信息
     * @param productCode
     * @return
     */
    CigaretteVO getCigaretteInfo(String productCode);
}

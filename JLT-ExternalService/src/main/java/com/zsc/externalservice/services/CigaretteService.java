package com.zsc.externalservice.services;

import com.zsc.externalservice.entity.vo.CigaretteVO;

import java.util.List;

public interface CigaretteService {

    /**
     * 在远程数据获取到所有香烟消息
     * @return List
     */
    List<CigaretteVO> getAll();
}

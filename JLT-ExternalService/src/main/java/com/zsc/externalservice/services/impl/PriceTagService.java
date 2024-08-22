package com.zsc.externalservice.services.impl;


import com.zsc.externalservice.entity.PriceOverview;
import com.zsc.externalservice.entity.Product;
import com.zsc.externalservice.mapper.PriceTagMapper;
import com.zsc.externalservice.services.IPriceTagService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceTagService implements IPriceTagService {


    private static final Logger log = LoggerFactory.getLogger(PriceTagService.class);
    @Autowired
    private PriceTagMapper priceTagMapper;

//    public List<PriceTag> findAll() {
//        return priceTagMapper.findAll();
//    }

//    @Override
//    public List<PriceTag> getPriceByNamess(List<String> names) {
//        return priceTagMapper.getPriceByNamess(names);
//    }

    @Override
    public List<Product> getPriceByNamesss(List<String> names) {
        log.info("名字列表names:{}", names);
        if (names.isEmpty()) {
            return null;
        }
        return priceTagMapper.getPriceByNames(names);
//        return priceTagMapper.test(names.get(0));
    }

//    public int insert(PriceTag priceTag) {
//        return priceTagMapper.insert(priceTag);
////        return 0;
//    }

//    public int deleteById(String id) {
//        return priceTagMapper.deleteByPrimaryKey(id);
//    }


//    public int update(PriceTag priceTag) {
//        return priceTagMapper.updateByPrimaryKeySelective(priceTag);
////        return 0;
//    }

    /**
     * 获取价格总览
     * @return List<priceOverview>
     */
    @Override
    public List<PriceOverview> getPriceOverview() {
        return priceTagMapper.getPriceOverview();
    }
}
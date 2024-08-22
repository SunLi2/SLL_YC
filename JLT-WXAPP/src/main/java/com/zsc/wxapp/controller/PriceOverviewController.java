package com.zsc.wxapp.controller;


import com.zsc.wxapp.entity.external.PriceOverview;
import com.zsc.wxapp.exservices.Remote2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@Controller
public class PriceOverviewController {
    @Autowired
    private Remote2 remote2;
    @GetMapping("/price_overview")
    public List<PriceOverview> getPriceOverview(){
        List<PriceOverview> list=remote2.getPriceOverview();
        return list;
    }
}

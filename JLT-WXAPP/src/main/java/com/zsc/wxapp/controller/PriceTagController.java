package com.zsc.wxapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zsc.wxapp.entity.PriceTag;
import com.zsc.wxapp.entity.Result;
import com.zsc.wxapp.entity.external.PriceNameData;
import com.zsc.wxapp.entity.external.ProductDetails;
import com.zsc.wxapp.entity.external.PriceOverview;
import com.zsc.wxapp.services.IPriceTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricetags")
public class PriceTagController {

    @Autowired
    private IPriceTagService priceTagService;

    /**
     * 获取所有价格标签
     * @return
     */
    @GetMapping("/getAllPriceTags")
    public Result getAllPriceTags() {
        List<PriceTag> priceTags = priceTagService.findAll();
        Result r = new Result("200", "success", priceTags);
        return r;
    }

    /**
     * 创建价格标签
     * @param priceTag
     * @return
     */
    @PostMapping("/createPriceTag")
    @ResponseStatus(HttpStatus.CREATED)
    public int createPriceTag(@RequestBody PriceTag priceTag) {
        return priceTagService.insert(priceTag);
    }

//    @PostMapping("/updatePriceTag")
//    public int updatePriceTag(@RequestBody PriceTag priceTag) {
//        return priceTagService.update(priceTag);
//    }

    /**
     * 删除价格标签
     * @param jsonString
     * @return
     */
    @PostMapping("/deletePriceTag")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public int deletePriceTag(@RequestBody String jsonString) {
        // Parse JSON string to JSONObject
        JSONObject jsonObject = JSON.parseObject(jsonString);

        // Extract fields
        String id = jsonObject.getString("id");

        System.out.println("id=" + id);
        int rows = priceTagService.deleteById(id);
        if (rows > 0) {
            return 200;
        }
        return 404;
    }


    /**
     * 获取价格概览
     * @return
     */
    @GetMapping("/getPriceOverview")
    public List<PriceOverview> getPriceOverview() {
        List<PriceOverview> list = priceTagService.getPriceOverview();
        return list;
    }

    /**
     * 根据产品uuid获取价格数据
     * @param productUuid
     * @return
     */
    @PostMapping("/getDataByProduct_uuid")
    public ResponseEntity<String> getDataByProduct_uuid(@RequestBody String productUuid) {
        List<PriceNameData> listPriceData = priceTagService.getPriceData(productUuid);
        List<ProductDetails> listproductDeatils = priceTagService.getProductDetails(productUuid);
        JSONObject responseJson = new JSONObject();
        responseJson.put("listPriceData", listPriceData);
        responseJson.put("listproductDeatils", listproductDeatils);
        return ResponseEntity.ok(responseJson.toString());
    }

}

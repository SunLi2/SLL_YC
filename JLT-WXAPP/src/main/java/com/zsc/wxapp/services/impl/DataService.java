package com.zsc.wxapp.services.impl;

import com.zsc.wxapp.entity.PicUrl;
import com.zsc.wxapp.entity.PriceTag1;
import com.zsc.wxapp.entity.PriceTag;
import com.zsc.wxapp.entity.dto.PriceTagDto;
import com.zsc.wxapp.entity.RequestDto;
import com.zsc.wxapp.mapper.PicUrlMapper;
import com.zsc.wxapp.mapper.PriceTagMapper;
import com.zsc.wxapp.utils.OSSUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class DataService {

    @Autowired
    private PicUrlMapper picUrlMapper;

    @Autowired
    private PriceTagMapper priceTagMapper;
    @Autowired
    private OSSUploadUtil ossUploadUtil;

    @Transactional
    public void processRequest(RequestDto requestDto) {
        List<PriceTagDto> dtos = requestDto.getRes();

        // Group by URL to batch process
        Map<String, List<PriceTagDto>> groupedByUrl = new HashMap<>();
        for (PriceTagDto dto : dtos) {
            groupedByUrl.computeIfAbsent(dto.getPtUrl(), k -> new ArrayList<>()).add(dto);
        }

        // Create a set to track processed URLs
        Set<String> processedUrls = new HashSet<>();
        List<PicUrl> picUrlsToInsert = new ArrayList<>();
        List<PriceTag> priceTagsToInsert = new ArrayList<>();


        try {
            for (Map.Entry<String, List<PriceTagDto>> entry : groupedByUrl.entrySet()) {
                String ptUrl = entry.getKey();
                List<PriceTagDto> priceTagDtos = entry.getValue();
                String jltPicUrlid = UUID.randomUUID().toString();

                // Check if the PicUrl with the given ptUrl already exists
                if (!processedUrls.contains(ptUrl)) {
                    PicUrl picUrl = new PicUrl();
                    picUrl.setPic_urlid(jltPicUrlid);
                    picUrl.setPic_userid(priceTagDtos.get(0).getCust_uuid()); // Assume all have the same custUuid
                    picUrl.setPic_url(ptUrl);
                    ZonedDateTime beijingDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
                    String create_time = beijingDateTime.format(formatter);
                    picUrl.setPic_create_time(create_time);
                    picUrlsToInsert.add(picUrl);
                    processedUrls.add(ptUrl);
                }

                // Add PriceTag1 entries
                for (PriceTagDto dto : priceTagDtos) {
                    String uniquePtUrlUuid = UUID.randomUUID().toString();

                    String ProductUuid = priceTagMapper.findProductUuidByProductName(dto.getProduct_name());

                    PriceTag priceTag1 = new PriceTag();
                    priceTag1.setPt_uuid(uniquePtUrlUuid);
                    priceTag1.setPic_urlid(jltPicUrlid);
                    priceTag1.setProduct_uuid(ProductUuid);
                    priceTag1.setCust_uuid(dto.getCust_uuid());
                    priceTag1.setProduct_name(dto.getProduct_name());
                    priceTag1.setRecognized_price(dto.getRecognized_price());
                    priceTag1.setPt_type(dto.getPt_type());
                    ZonedDateTime beijingDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
                    String create_time = beijingDateTime.format(formatter);
                    priceTag1.setPt_create_date(create_time);
                    // 设置其他字段
                    priceTagsToInsert.add(priceTag1);
                }
            }

            // Batch insert PicUrl and PriceTag1 entries
            if (!picUrlsToInsert.isEmpty()) {
                picUrlMapper.insertPicUrls(picUrlsToInsert);
            }

            if (!priceTagsToInsert.isEmpty()) {
                priceTagMapper.insertPriceTags(priceTagsToInsert);
            }

        } catch (Exception e) {
            // 删除已上传的图像
            for (String ptUrl : processedUrls) {
                ossUploadUtil.deleteImage(ptUrl);
            }
            throw e; // 重新抛出异常，以便事务回滚
        }
    }
}


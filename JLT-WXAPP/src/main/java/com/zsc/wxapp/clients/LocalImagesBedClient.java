package com.zsc.wxapp.clients;


import com.zsc.wxapp.config.FeignMultipartSupportConfig;

import com.zsc.wxapp.entity.Result;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "JLT-ImagesBed", url = "http://localhost:8088" ,configuration= FeignMultipartSupportConfig.class, contextId = "test01")
public interface LocalImagesBedClient {

    @PostMapping(value ="/api/localimagesbed/wx_upload", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result upload_save_image(@RequestPart("file") MultipartFile file, @RequestParam("userid") String userid);
}




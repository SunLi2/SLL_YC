package com.zsc.wxapp.clients;

import com.zsc.wxapp.config.FeignMultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "PriceTagRecognition",url = "http://localhost:5000", configuration = FeignMultipartSupportConfig.class, contextId = "test02")
public interface pythonPriceTagRecognitionClient {

    @PostMapping(value = "/inference", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> pythonPriceTagRecognition(
            @RequestPart("data") String data,
            @RequestPart("url") String url,
            @RequestPart("image") MultipartFile image);
//    MultipartFile file

}

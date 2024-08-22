package com.zsc.wxapp.clients;

import com.zsc.wxapp.config.FeignMultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name = "remotePriceTagRecognition", url = "http://localhost:8089", configuration = FeignMultipartSupportConfig.class, contextId = "test04")
public interface RemotePriceTagRecognition {
    @PostMapping(value = "/detect",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> remotePriceTagRecognition(
            @RequestPart("file_list") MultipartFile file,
            @RequestPart("model_name") String modelName,
            @RequestPart("download_image") String downloadImage);
}

package com.zsc.wxapp.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class ApiService {

    @Value("${api.local.url}")
    private String apiLocalUrl;

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        String fullUrl = apiLocalUrl + "/detect";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("apikey", "oE2PzTohoiDMwbUIZuJXyGK2Shzd1de");

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file_list", file.getResource().getInputStream());
        body.add("model_name", "custom");
        body.add("download_image", "true");

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(fullUrl, HttpMethod.POST, requestEntity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to upload image: " + response.getStatusCode());
        }
    }
}
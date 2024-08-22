package com.zsc.wxapp.services.impl;


import com.zsc.wxapp.entity.PythonResponse;
import com.zsc.wxapp.services.IImageInferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageInferenceService implements IImageInferenceService {

    @Value("${api.local.url}")
    private String apiLocalUrl;

    @Autowired
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    /**
     * 使用 Python API 进行推理操作
     * @param imageUrl
     * @return
     * @throws IOException
     */
    public PythonResponse performInference(String imageUrl) throws IOException {
        // 创建请求
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "image/jpeg"); // 根据图像类型设置适当的 MIME 类型

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // 发送 GET 请求获取图像数据
        ResponseEntity<byte[]> response = restTemplate.exchange(imageUrl, HttpMethod.GET, requestEntity, byte[].class);

        // 获取图像数据
        byte[] imageData = response.getBody();

        // 将字节数组转为输入流
        InputStream imageStream = new ByteArrayInputStream(imageData);

        // 进行推理操作
        PythonResponse result =performInferenceOnImageStream(imageStream);
        return result;
    }

    /**
     * 使用 Python API 进行推理操作
     * @param imageStream
     * @return
     */
    @Override
    public PythonResponse performInferenceOnImageStream(InputStream imageStream) {
        // 在这里实现图像推理的逻辑
        // 例如，将输入流传递给深度学习模型进行推理

        String fullUrl = apiLocalUrl + "/detect";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("apikey", "oE2PzTohoiDMwbUIZuJXyGK2Shzd1de");

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file_list", imageStream);
        body.add("model_name", "custom");
        body.add("download_image", "true");

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        //返回第一次调用远程接口 response
        ResponseEntity<String> response = restTemplate.exchange(fullUrl, HttpMethod.POST, requestEntity, String.class);

        //请求python接口
        String url = "http://localhost:5000/inference";
        MultiValueMap<String, Object> body_2 = new LinkedMultiValueMap<>();
        body_2.add("data", response);
        body_2.add("image", imageStream);

        HttpHeaders headers_2 = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity_2 = new HttpEntity<>(body_2, headers_2);

        ResponseEntity<String> response_2 = restTemplate.postForEntity(url, requestEntity_2, String.class);
        String jsonResponse = response_2.getBody();

        if (jsonResponse != null) {
            try {
                // 使用 ObjectMapper 将 JSON 字符串转换为 PythonResponse 对象
                PythonResponse pythonResponse=objectMapper.readValue(jsonResponse, PythonResponse.class);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        PythonResponse result = new PythonResponse();
        return result;
    }


}

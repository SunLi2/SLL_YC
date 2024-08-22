package com.zsc.wxapp.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUploadRequest {
    private MultipartFile file;
    private String userid;

    // 构造函数、getter和setter省略
}
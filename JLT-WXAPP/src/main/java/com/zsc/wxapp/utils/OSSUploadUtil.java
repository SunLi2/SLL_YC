package com.zsc.wxapp.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.zsc.wxapp.config.OSSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Component
public class OSSUploadUtil {

    @Autowired
    private OSSConfig ossConfig;

    public String uploadImage(MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        try (InputStream inputStream = file.getInputStream()) {
            // 创建 OSSClient 实例
            OSS ossClient = new OSSClientBuilder().build(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());

            try {
                // 构建上传请求
                PutObjectRequest putObjectRequest = new PutObjectRequest(ossConfig.getBucketName(), fileName, inputStream);

                // 上传文件
                ossClient.putObject(putObjectRequest);

                // 获取文件的 URL
                String fileUrl = "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint() + "/" + fileName;
                return fileUrl;
            } finally {
                // 关闭 OSSClient
                ossClient.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteImage(String fileUrl) {
        try {
            // 创建 OSSClient 实例
            OSS ossClient = new OSSClientBuilder().build(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());

            try {
                // 从 URL 中提取文件名
                String fileName = extractFileNameFromUrl(fileUrl);

                // 删除文件
                ossClient.deleteObject(ossConfig.getBucketName(), fileName);
            } finally {
                // 关闭 OSSClient
                ossClient.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractFileNameFromUrl(String fileUrl) {
        // 从 URL 中提取文件名（假设 URL 格式为 https://bucket-name.endpoint/file-name）
        String[] parts = fileUrl.split("/");
        return parts[parts.length - 1];
    }

}

